//Student name - Chamod gimhana peiris
//Student ID - 24723297
//Ride.java
//import utilities for collections and file handling
import java.util.*;
import java.io.*;                              //for reading and writing files

//abstract class Ride implements RideInterface, meaning every ride must follow its rules
public abstract class Ride implements RideInterface {

    //name of the ride
    protected String rideName;

    //employee who operates the ride
    protected Employee operator;

    //maximum number of people who can ride at once
    protected int maxGroupSize;

    //queue of visitors waiting to take the ride (FIFO order)
    protected Queue<Visitor> visitorQueue;

    //list of all visitors who have already taken the ride (ride history)
    protected LinkedList<Visitor> rideHistory; // Must be LinkedList per assignment rules

    //number of times the ride has been run
    protected int numOfCycles = 0;

    //getter for number of cycles
    public int getNumOfCycles() {
        return numOfCycles;
    }

    //default constructor (empty ride name, no operator, group size of 1)
    public Ride() {
        this("", null, 1);
    }

    //allow access to rideHistory list from outside (used for validation or viewing)
    public java.util.LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    //allow access to visitorQueue from outside (used for validation or viewing)
    public java.util.Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }

    //main constructor to create a ride with given name, operator, and max group size
    public Ride(String rideName, Employee operator, int maxGroupSize) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxGroupSize = maxGroupSize;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    //getters and setters for ride details
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxGroupSize() { return maxGroupSize; }
    public void setMaxGroupSize(int maxGroupSize) { this.maxGroupSize = maxGroupSize; }

    //sort the ride history based on a given comparison method (e.g., by name or ticket type)
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted successfully.");
    }

    //add a visitor to the waiting queue
    @Override
    public void addVisitorToQueue(Visitor visitor) { visitorQueue.add(visitor); }

    //remove the next visitor from the queue (FIFO) and print confirmation
    @Override
    public void removeVisitorFromQueue() {
        Visitor v = visitorQueue.poll();
        if (v != null) System.out.println(v.getName() + " removed from queue.");
        else System.out.println("No visitor to remove.");
    }

    //print all visitors currently in the queue
    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            for (Visitor v : visitorQueue) {
                System.out.println(" - " + v.getName() + " | Age: " + v.getAge() +
                        " | ID: " + v.getId() + " | Ticket: " + v.getTicketType() +
                        " | Group: " + v.getGroupSize());
            }
        }
    }

    //add a visitor to the ride history after they complete the ride
    @Override
    public void addVisitorToHistory(Visitor visitor) { rideHistory.add(visitor); }

    //check if a visitor is already in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) { return rideHistory.contains(visitor); }

    //return the total number of visitors who have taken the ride
    @Override
    public int numberOfVisitors() { return rideHistory.size(); }

    //print all visitors from the ride history using an Iterator (required by assignment)
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history.");
        } else {
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                Visitor v = it.next();
                System.out.println(" - " + v.getName() + " | ID: " + v.getId() + " | Ticket: " + v.getTicketType());
            }
        }
    }

    //save ride history to a file (Part 6 of assignment)
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                Visitor v = it.next();
                writer.write(v.getName() + "," + v.getAge() + "," + v.getId() + "," +
                             v.getTicketType() + "," + v.getGroupSize());
                writer.newLine();
            }
            System.out.println("Ride history successfully saved to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving ride history: " + e.getMessage());
        }
    }

    //load ride history from a file (Part 7 of assignment)
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String id = parts[2];
                    String ticketType = parts[3];
                    int groupSize = Integer.parseInt(parts[4]);
                    rideHistory.add(new Visitor(name, age, id, ticketType, groupSize));
                } else {
                    System.out.println("Invalid line in file: " + line);
                }
            }
            System.out.println("Ride history successfully imported from: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
    }

    //abstract method - each ride type must decide how to run one cycle
    @Override
    public abstract void runOneCycle();
}
