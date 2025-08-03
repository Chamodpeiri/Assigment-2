import java.util.Scanner;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo a = new AssignmentTwo();
        a.partThree();
        a.partFourA();
        a.partFourB();
        a.partFive();
        a.partSix();
        a.partSeven();
        a.supervisorMenu(); // ✅ Optional enhancement
    }

    public void partThree() {
        System.out.println("\n--- PART 3: Visitor Queue ---");

        Employee operator = new Employee("Alice", 35, "EMP001", "Operator", 5);
        Ride ride = new Ride("Roller Coaster", operator, 3);

        Visitor v1 = new Visitor("Visitor1", 21, "ID1", "Regular", 1);
        Visitor v2 = new Visitor("Visitor2", 22, "ID2", "Regular", 1);
        Visitor v3 = new Visitor("Visitor3", 23, "ID3", "Regular", 1);
        Visitor v4 = new Visitor("Visitor4", 24, "ID4", "Regular", 1);
        Visitor v5 = new Visitor("Visitor5", 25, "ID5", "Regular", 1);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n--- PART 4A: Ride History ---");
        Ride ride = new Ride();

        Visitor v1 = new Visitor("Visitor1", 21, "ID1", "Regular", 1);
        Visitor v2 = new Visitor("Visitor2", 22, "ID2", "Regular", 1);
        Visitor v3 = new Visitor("Visitor3", 23, "ID3", "Regular", 1);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);

        ride.checkVisitorFromHistory(v2);
        System.out.println("Total in history: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n--- PART 4B: Sorted History ---");
        Ride ride = new Ride();

        ride.addVisitorToHistory(new Visitor("Zara", 30, "ID6", "VIP", 2));
        ride.addVisitorToHistory(new Visitor("Alex", 21, "ID7", "Regular", 1));
        ride.addVisitorToHistory(new Visitor("Bella", 25, "ID8", "Regular", 1));

        System.out.println("Before Sorting:");
        ride.printRideHistory();

        ride.sortRideHistory(new VisitorComparator());

        System.out.println("After Sorting:");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n--- PART 5: Run One Ride Cycle ---");
        Employee operator = new Employee("John", 40, "EMP002", "Supervisor", 10);
        Ride ride = new Ride("Sky Swing", operator, 3);

        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "ID" + i, "Regular", 1));
        }

        System.out.println("\nQueue before cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("\nQueue after 1 cycle:");
        ride.printQueue();

        System.out.println("\nRide History:");
        ride.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n--- PART 6: Export History to File ---");
        Ride ride = new Ride();
        ride.addVisitorToHistory(new Visitor("Eva", 26, "ID9", "Regular", 2));
        ride.addVisitorToHistory(new Visitor("Mark", 28, "ID10", "VIP", 3));
        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println("\n--- PART 7: Import History from File ---");
        Ride ride = new Ride();
        ride.importRideHistory("ride_history.csv");
        System.out.println("Imported Visitors Count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    // ✅ Supervisor Menu Enhancement
    public void supervisorMenu() {
        Scanner scanner = new Scanner(System.in);
        Ride ride = new Ride("Super Swing", new Employee("Liam", 34, "EMP003", "Operator", 4), 3);

        while (true) {
            System.out.println("\n🎡 Supervisor Menu:");
            System.out.println("1. Add Visitor to Queue");
            System.out.println("2. Remove Visitor from Queue");
            System.out.println("3. View Queue");
            System.out.println("4. Run One Ride Cycle");
            System.out.println("5. View Ride History");
            System.out.println("6. Export History to CSV");
            System.out.println("7. Import History from CSV");
            System.out.println("8. Sort Ride History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter ticket type: ");
                    String ticket = scanner.nextLine();
                    System.out.print("Enter group number: ");
                    int group = Integer.parseInt(scanner.nextLine());

                    Visitor v = new Visitor(name, age, id, ticket, group);
                    ride.addVisitorToQueue(v);
                    break;

                case 2:
                    ride.removeVisitorFromQueue();
                    break;

                case 3:
                    ride.printQueue();
                    break;

                case 4:
                    ride.runOneCycle();
                    break;

                case 5:
                    ride.printRideHistory();
                    break;

                case 6:
                    ride.exportRideHistory("ride_history.csv");
                    break;

                case 7:
                    ride.importRideHistory("ride_history.csv");
                    break;

                case 8:
                    ride.sortRideHistory(new VisitorComparator());
                    break;

                case 0:
                    System.out.println("Exiting Supervisor Menu.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
