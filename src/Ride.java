// Ride.java
import java.util.*;
import java.io.*; // Added for file writing and reading

public abstract class Ride implements RideInterface {
    protected String rideName;
    protected Employee operator;
    protected int maxGroupSize;
    protected Queue<Visitor> visitorQueue;

    // ✅ must be LinkedList per rubric
    protected LinkedList<Visitor> rideHistory;

    // ✅ Added for Part 5 cycle counting
    protected int numOfCycles = 0;

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public Ride() {
        this("", null, 1);
    }

    // expose for validation checks in the menu
public java.util.LinkedList<Visitor> getRideHistory() {
    return rideHistory;
}

public java.util.Queue<Visitor> getVisitorQueue() {
    return visitorQueue;
}


    public Ride(String rideName, Employee operator, int maxGroupSize) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxGroupSize = maxGroupSize;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxGroupSize() { return maxGroupSize; }
    public void setMaxGroupSize(int maxGroupSize) { this.maxGroupSize = maxGroupSize; }

    // ✅ Part 4B: Sort ride history with Comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted successfully.");
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) { visitorQueue.add(visitor); }

    @Override
    public void removeVisitorFromQueue() {
        Visitor v = visitorQueue.poll();
        if (v != null) System.out.println(v.getName() + " removed from queue.");
        else System.out.println("No visitor to remove.");
    }

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

    @Override
    public void addVisitorToHistory(Visitor visitor) { rideHistory.add(visitor); }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) { return rideHistory.contains(visitor); }

    @Override
    public int numberOfVisitors() { return rideHistory.size(); }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history.");
        } else {
            // ✅ must use Iterator per rubric
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                Visitor v = it.next();
                System.out.println(" - " + v.getName() + " | ID: " + v.getId() + " | Ticket: " + v.getTicketType());
            }
        }
    }

    // Part 6
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                Visitor v = it.next();
                writer.write(v.getName() + "," + v.getAge() + "," + v.getId() + "," +
                             v.getTicketType() + "," + v.getGroupSize());
                writer.newLine();
            }
            System.out.println("✅ Ride history successfully saved to: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving ride history: " + e.getMessage());
        }
    }

    // Part 7
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
                    System.out.println("❌ Invalid line in file: " + line);
                }
            }
            System.out.println("✅ Ride history successfully imported from: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid number format in file.");
        }
    }

    @Override
    public abstract void runOneCycle();
}
