//Student name - Chamod gimhana peiris
//Student ID - 24723297
// FerrisWheelRide.java
//this class represents a Ferris Wheel ride and extends the common Ride class
public class FerrisWheelRide extends Ride {

    //constructor to set the ride name, operator, and maximum group size
    public FerrisWheelRide(String rideName, Employee operator, int maxGroupSize) {
        super(rideName, operator, maxGroupSize);
    }

    //this method runs one cycle of the Ferris Wheel ride
    @Override
    public void runOneCycle() {

        //check if there is an operator assigned before starting
        if (getOperator() == null) {
            System.out.println("No operator assigned. Cannot start ride.");
            return;
        }

        //check if there are any visitors in the queue before starting
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in queue.");
            return;
        }

        //start the ride and display the ride name
        System.out.println("\n Starting ride: " + getRideName());
        int taken = 0;

        //load visitors onto the ride until max group size is reached or queue is empty
        while (taken < getMaxGroupSize() && !visitorQueue.isEmpty()) {
            Visitor v = visitorQueue.poll();                                             //remove visitor from the front of the queue (FIFO)
            addVisitorToHistory(v);                                                      //add the visitor to the ride history
            System.out.println(" - On the wheel: " + v.getName() + " [Group Size: " + v.getGroupSize() + "]");
            taken++;
        }

        //increase the number of ride cycles completed
        numOfCycles++;

        //display ride completion message and the number of visitors in this cycle
        System.out.println("Ride complete. " + taken + " visitor(s) enjoyed the view.");

        //show the total number of cycles run so far
        System.out.println("Number of cycles so far: " + numOfCycles);
    }
}
