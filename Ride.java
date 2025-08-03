import java.io.*;
import java.util.*;

/**
 * Represents a theme park ride, including visitor queue,
 * ride history, operator, and ride cycle logic.
 */
public class Ride implements RideInterface {

    private String rideName;
    private Employee rideOperator;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    // Constructors
    public Ride() {
        this("Unnamed Ride", null, 3);
    }

    public Ride(String rideName, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideOperator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Setters and Getters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getRideOperator() { return rideOperator; }
    public void setRideOperator(Employee rideOperator) { this.rideOperator = rideOperator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

    public int getNumOfCycles() { return numOfCycles; }

    // Queue Management
    @Override
    public void addVisitorToQueue(Visitor v) {
        queue.add(v);
        System.out.println(v.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = queue.poll();
        if (removed != null) {
            System.out.println(removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("\nVisitors in Queue:");
            for (Visitor v : queue) {
                System.out.println(" - " + v);
            }
        }
    }

    // Ride History Management
    @Override
    public void addVisitorToHistory(Visitor v) {
        rideHistory.add(v);
        System.out.println(v.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        boolean found = rideHistory.contains(v);
        System.out.println(v.getName() + (found ? " is in ride history." : " is NOT in ride history."));
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
        } else {
            System.out.println("\nVisitors in Ride History:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                System.out.println(" - " + iterator.next());
            }
        }
    }

    // Ride Cycle Execution
    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("❌ No operator assigned. Ride cannot be run.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("❌ Queue is empty. No visitors to take the ride.");
            return;
        }

        System.out.println("\n🎢 Running ride cycle...");
        int count = Math.min(maxRider, queue.size());

        for (int i = 0; i < count; i++) {
            Visitor v = queue.poll();
            if (v != null) {
                addVisitorToHistory(v);
            }
        }

        numOfCycles++;
        System.out.println("✅ Ride cycle complete. Total cycles run: " + numOfCycles);
    }

    // Export ride history to CSV
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name,Age,ID,Ticket Type,Group Number");
            writer.newLine();

            for (Visitor v : rideHistory) {
                writer.write(v.getName() + "," +
                             v.getAge() + "," +
                             v.getId() + "," +
                             v.getTicketType() + "," +
                             v.getGroupNumber());
                writer.newLine();
            }

            System.out.println("✅ Ride history exported to file: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error exporting ride history: " + e.getMessage());
        }
    }

    // Import ride history from CSV
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean skipHeader = true;

            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String id = parts[2];
                    String ticket = parts[3];
                    int group = Integer.parseInt(parts[4]);

                    Visitor v = new Visitor(name, age, id, ticket, group);
                    addVisitorToHistory(v);
                }
            }

            System.out.println("✅ Ride history imported from file: " + filename);
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error importing ride history: " + e.getMessage());
        }
    }

    // Sort ride history using custom comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("✅ Ride history sorted successfully.");
    }
}
