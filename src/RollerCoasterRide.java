//Student name - Chamod gimhana peiris
//Student ID - 24723297
// RollerCoasterRide.java
//this class represents a specific type of ride (Roller Coaster) that extends the generic Ride class
public class RollerCoasterRide extends Ride {

    //constructor to set up the roller coaster ride with name, operator, and max group size
    public RollerCoasterRide(String rideName, Employee operator, int maxGroupSize) {
        super(rideName, operator, maxGroupSize);                          //calls Ride class constructor
    }

    //this method runs one ride cycle for the roller coaster
    @Override
    public void runOneCycle() {
        //if no operator is assigned, stop the ride
        if (getOperator() == null) {
            System.out.println("No operator assigned. Cannot start ride.");
            return;
        }
        //if there are no visitors in the queue, stop the ride
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in queue.");
            return;
        }

        //start the ride and show its name.
        System.out.println("\n Starting ride: " + getRideName());
        int taken = 0;                                                // Counter for how many visitors are riding this cycle

        // while there is space and visitors in the queue, load them onto the ride
        while (taken < getMaxGroupSize() && !visitorQueue.isEmpty()) {
            Visitor v = visitorQueue.poll();                          //takes the first visitor from the queue (FIFO)
            addVisitorToHistory(v);                                   //adds visitor to ride history
            System.out.println(" - Riding: " + v.getName() + " [Ticket: " + v.getTicketType() + "]");
            taken++;                                                  // increase count of visitors taken in this cycle
        }

        numOfCycles++;                                                //increments the total number of cycles this ride has run
        System.out.println("Ride finished with " + taken + " visitor(s).");
        System.out.println("Number of cycles so far: " + numOfCycles);
    }
}
