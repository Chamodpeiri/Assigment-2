// RollerCoasterRide.java
public class RollerCoasterRide extends Ride {
    public RollerCoasterRide(String rideName, Employee operator, int maxGroupSize) {
        super(rideName, operator, maxGroupSize);
    }

    @Override
public void runOneCycle() {
    if (getOperator() == null) {
        System.out.println("❌ No operator assigned. Cannot start ride.");
        return;
    }
    if (visitorQueue.isEmpty()) {
        System.out.println("❌ No visitors in queue.");
        return;
    }

    System.out.println("\n🎢 Starting ride: " + getRideName());
    int taken = 0;
    while (taken < getMaxGroupSize() && !visitorQueue.isEmpty()) {
        Visitor v = visitorQueue.poll();      // FIFO
        addVisitorToHistory(v);               // move to history
        System.out.println(" - Riding: " + v.getName() + " [Ticket: " + v.getTicketType() + "]");
        taken++;
    }

    numOfCycles++; // ✅ increment cycle count
    System.out.println("Ride finished with " + taken + " visitor(s).");
    System.out.println("Number of cycles so far: " + numOfCycles);
}
}