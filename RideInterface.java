public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    void runOneCycle();
    void exportRideHistory(String filename);
    void importRideHistory(String filename);
}
