import java.util.*;

public class RideManager {
    private LinkedList<Ride> rides;

    public RideManager() {
        rides = new LinkedList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void sortRidesByName() {
        Collections.sort(rides, Comparator.comparing(Ride::getRideName, String::compareToIgnoreCase));
    }

    public void displayAllRides() {
        System.out.println("\n🎠 Available Rides:");
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
            return;
        }
        for (Ride ride : rides) {
            System.out.println("Ride: " + ride.getRideName() + " | Operator: " + ride.getOperator().getName());
        }
    }

    public void displayQueues() {
        System.out.println("\n📋 Current Ride Queues:");
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
            return;
        }
        for (Ride ride : rides) {
            System.out.println("\nRide: " + ride.getRideName());
            ride.printQueue();
        }
    }

    public void startAllRides() {
        System.out.println("\n🎬 Starting All Rides:");
        if (rides.isEmpty()) {
            System.out.println("No rides to start.");
            return;
        }
        for (Ride ride : rides) {
            ride.runOneCycle();
        }
    }

    public LinkedList<Ride> getAllRides() {
        return rides;
    }

    // ✅ Added for menu option 7 (export)
    public Ride findRideByName(String rideName) {
        for (Ride ride : rides) {
            if (ride.getRideName().equalsIgnoreCase(rideName)) {
                return ride;
            }
        }
        return null; // Not found
    }
}
