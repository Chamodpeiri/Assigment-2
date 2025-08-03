public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
        a2.partSix();
        a2.partSeven();
    }

    public void partThree() {
        System.out.println("\n--- PART 3: Visitor Queue ---");
        Ride ride = new Ride("Jungle Spin", "Adventure", null, 5);

        for (int i = 1; i <= 5; i++) {
            Visitor v = new Visitor("Visitor" + i, 20 + i, "ID" + i, "Regular", 1);
            ride.addVisitorToQueue(v);
        }

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n--- PART 4A: Ride History ---");
        Ride ride = new Ride("Rocket Blaster", "Thrill", null, 5);

        for (int i = 6; i <= 10; i++) {
            Visitor v = new Visitor("Visitor" + i, 25 + i, "ID" + i, "Premium", 2);
            ride.addVisitorToHistory(v);
        }

        Visitor searchV = new Visitor("Visitor7", 32, "ID7", "Premium", 2);
        System.out.println("Is Visitor7 in history? " + ride.checkVisitorFromHistory(searchV));
        System.out.println("Total visitors in history: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n--- PART 4B: Sort Ride History ---");
        Ride ride = new Ride("Sky Drop", "Extreme", null, 5);

        ride.addVisitorToHistory(new Visitor("Zane", 28, "V101", "VIP", 3));
        ride.addVisitorToHistory(new Visitor("Anna", 22, "V102", "Regular", 1));
        ride.addVisitorToHistory(new Visitor("Mark", 25, "V103", "Regular", 2));
        ride.addVisitorToHistory(new Visitor("Liam", 24, "V104", "Premium", 1));
        ride.addVisitorToHistory(new Visitor("Emma", 23, "V105", "Regular", 2));

        System.out.println("Before Sorting:");
        ride.printRideHistory();

        ride.sortRideHistory(new VisitorComparator());

        System.out.println("After Sorting:");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n--- PART 5: Run Ride Cycle ---");
        Employee operator = new Employee("Tom", 35, "EMP001", "Ride Operator", "Morning");
        Ride ride = new Ride("Aqua Loop", "Water", operator, 3);

        for (int i = 11; i <= 20; i++) {
            Visitor v = new Visitor("Visitor" + i, 18 + i, "ID" + i, "Regular", 1);
            ride.addVisitorToQueue(v);
        }

        System.out.println("Queue before cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Queue after 1 cycle:");
        ride.printQueue();

        System.out.println("Visitors in history:");
        ride.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n--- PART 6: Export Ride History ---");
        Ride ride = new Ride("Dragon Coaster", "Classic", null, 4);

        ride.addVisitorToHistory(new Visitor("Alice", 21, "ID201", "Regular", 1));
        ride.addVisitorToHistory(new Visitor("Bob", 24, "ID202", "VIP", 2));
        ride.addVisitorToHistory(new Visitor("Cleo", 23, "ID203", "Premium", 1));
        ride.addVisitorToHistory(new Visitor("Dane", 26, "ID204", "Regular", 3));
        ride.addVisitorToHistory(new Visitor("Ella", 22, "ID205", "VIP", 1));

        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println("\n--- PART 7: Import Ride History ---");
        Ride ride = new Ride("Dragon Coaster Reloaded", "Classic", null, 4);
        ride.importRideHistory("ride_history.csv");

        System.out.println("Imported visitor count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}
 


chamod