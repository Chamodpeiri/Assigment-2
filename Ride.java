import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String name;
    private String category;
    private Employee operator;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> history;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.numOfCycles = 0;
    }

    public Ride(String name, String category, Employee operator, int maxRider) {
        this();
        this.name = name;
        this.category = category;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public void addVisitorToQueue(Visitor v) {
        queue.add(v);
        System.out.println(v.getName() + " added to queue.");
    }

    public void removeVisitorFromQueue() {
        Visitor v = queue.poll();
        if (v != null)
            System.out.println(v.getName() + " removed from queue.");
        else
            System.out.println("Queue is empty.");
    }

    public void printQueue() {
        System.out.println("\nVisitors in Queue:");
        for (Visitor v : queue)
            System.out.println(" - " + v);
    }

    public void addVisitorToHistory(Visitor v) {
        history.add(v);
        System.out.println(v.getName() + " added to ride history.");
    }

    public boolean checkVisitorFromHistory(Visitor v) {
        return history.stream().anyMatch(h -> h.getId().equals(v.getId()));
    }

    public int numberOfVisitors() {
        return history.size();
    }

    public void printRideHistory() {
        System.out.println("\nVisitors who took the ride:");
        Iterator<Visitor> it = history.iterator();
        while (it.hasNext()) System.out.println(" - " + it.next());
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(history, comparator);
        System.out.println("✅ Ride history sorted.");
    }

    public void runOneCycle() {
        if (operator == null) {
            System.out.println("❌ No ride operator assigned.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("❌ No visitors in queue.");
            return;
        }

        int count = Math.min(maxRider, queue.size());
        for (int i = 0; i < count; i++) {
            Visitor v = queue.poll();
            history.add(v);
            System.out.println("✅ " + v.getName() + " took the ride.");
        }
        numOfCycles++;
    }

    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : history) {
                writer.write(v.getName() + "," + v.getAge() + "," + v.getId() + "," +
                             v.getTicketType() + "," + v.getGroupSize());
                writer.newLine();
            }
            System.out.println("✅ Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Export error: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Visitor v = new Visitor(parts[0], Integer.parseInt(parts[1]), parts[2],
                        parts[3], Integer.parseInt(parts[4]));
                history.add(v);
            }
            System.out.println("✅ Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("❌ Import error: " + e.getMessage());
        }
    }
}
