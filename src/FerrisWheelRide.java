// FerrisWheelRide.java
public class FerrisWheelRide extends Ride {
    public FerrisWheelRide(String rideName, Employee operator, int maxGroupSize) {
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

    System.out.println("\n🎡 Starting ride: " + getRideName());
    int taken = 0;
    while (taken < getMaxGroupSize() && !visitorQueue.isEmpty()) {
        Visitor v = visitorQueue.poll();      // FIFO
        addVisitorToHistory(v);               // move to history
        System.out.println(" - On the wheel: " + v.getName() + " [Group Size: " + v.getGroupSize() + "]");
        taken++;
    }

    numOfCycles++; // ✅ increment cycle count
    System.out.println("Ride complete. " + taken + " visitor(s) enjoyed the view.");
    System.out.println("Number of cycles so far: " + numOfCycles);
}
}