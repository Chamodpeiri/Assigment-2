//Student name - Chamod gimhana peiris
//Student ID - 24723297
//RideInterface.java
// This interface defines the common actions that every ride must have
public interface RideInterface {

    //add a visitor to the ride's waiting queue
    void addVisitorToQueue(Visitor visitor);

    //remove the next visitor from the queue (usually after they ride)
    void removeVisitorFromQueue();

    //print the list of visitors currently in the queue
    void printQueue();

    //add a visitor to the ride's history (record of who has ridden)
    void addVisitorToHistory(Visitor visitor);

    //print the full ride history (all visitors who have taken the ride)
    void printRideHistory();

    //check if a specific visitor has ridden before (search in history)
    boolean checkVisitorFromHistory(Visitor visitor);

    //return the total number of visitors currently in the queue
    int numberOfVisitors();

    //run one cycle of the ride (let some visitors ride, then update history)
    void runOneCycle();
}
