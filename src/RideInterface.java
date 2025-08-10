public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();
    void addVisitorToHistory(Visitor visitor);
    void printRideHistory();
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void runOneCycle();
}
