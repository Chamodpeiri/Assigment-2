//Student name - Chamod gimhana peiris
//Student ID - 24723297
//RideManager.java
import java.util.*;

//this class manages all the rides in the theme park
public class RideManager {
    //linkedList to store all Ride objects (each ride in the park)
    private LinkedList<Ride> rides;

    //constructor -creates an empty list of rides when RideManager is created
    public RideManager() {
        rides = new LinkedList<>();
    }

    //method to add a new ride to the rides list.
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    //sorts the rides list alphabetically by ride name (ignoring the  upper/lower case)
    public void sortRidesByName() {
        Collections.sort(rides, Comparator.comparing(Ride::getRideName, String::compareToIgnoreCase));
    }

    //displays the list of all available rides with their operators
    public void displayAllRides() {
        System.out.println("\n Available Rides:");
        if (rides.isEmpty()) { //if there are no rides, show a message and exit
            System.out.println("No rides available.");
            return;
        }
        //loop through each ride and print its name and operator
        for (Ride ride : rides) {
            System.out.println("Ride: " + ride.getRideName() + " | Operator: " + ride.getOperator().getName());
        }
    }

    //displays all the queues for each ride (which visitors are waiting)
    public void displayQueues() {
        System.out.println("\n Current Ride Queues:");
        if (rides.isEmpty()) {                                //if there are no rides, show a message and exit
            System.out.println("No rides available.");
            return;
        }
        //loop through each ride and print the queue for that ride
        for (Ride ride : rides) {
            System.out.println("\nRide: " + ride.getRideName());
            ride.printQueue();                               //this method is in the Ride class
        }
    }

    //starts all rides one by one, running one cycle for each
    public void startAllRides() {
        System.out.println("\n Starting All Rides:");
        if (rides.isEmpty()) {                               //if there are no rides, show a message and exit
            System.out.println("No rides to start.");
            return;
        }
        //loop through each ride and run one ride cycle
        for (Ride ride : rides) {
            ride.runOneCycle();
        }
    }

    //returns the full list of rides (getter method)
    public LinkedList<Ride> getAllRides() {
        return rides;
    }

    //finds a ride in the list by name (used for export/import and searching)
    public Ride findRideByName(String rideName) {
        for (Ride ride : rides) {
            if (ride.getRideName().equalsIgnoreCase(rideName)) {           //match ignoring case.
                return ride;                                               //found and returned the ride.
            }
        }
        return null;          //if not found, return null.
    }
}
