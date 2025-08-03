/**
 * Interface for defining ride operations.
 */
public interface RideInterface {
    void addVisitorToQueue(Visitor v);
    void removeVisitorFromQueue();
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor v);
    boolean checkVisitorFromHistory(Visitor v);
    int numberOfVisitors();
    void printRideHistory();
}
