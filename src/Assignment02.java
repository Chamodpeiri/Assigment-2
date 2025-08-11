// Student name - Chamod Gimhana Peiris
// Student ID - 24723297
// Assignment02.java
import java.util.*;

public class Assignment02 {

    public static void main(String[] args) {
        new Assignment02().runAll();
    }

    private void runAll() {
        banner("PROG2004 – Park Rides Visitor Management System");
        partThree();
        divider();
        partFourA();
        divider();
        partFourB();
        divider();
        partFive();
        divider();
        partSix();
        divider();
        partSeven();
        divider();
        partEight();
        divider();
        supervisorMenu();
    }

    // ---------------------------------------------------
    // PART 3 - Queue interface
    // ---------------------------------------------------
    public void partThree() {
        banner("PART 3: Visitor Queue");
        Employee operator = new Employee("Alice", 35, "EMP001", "Operator", 5);
        Ride ride = new RollerCoasterRide("Roller Coaster", operator, 3);

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

        System.out.println("Removing the head of the queue...");
        ride.removeVisitorFromQueue();

        System.out.println("\nQueue (FIFO order):");
        ride.printQueue();
    }

    // ------------------------------------------------------------------
    // PART 4A — Ride history (LinkedList)
    // ------------------------------------------------------------------
    public void partFourA() {
        banner("PART 4A: Ride History (LinkedList + Iterator)");
        Ride ride = new RollerCoasterRide("Wild Rider",
                new Employee("Bob", 30, "EMP002", "Operator", 4), 3);

        Visitor v1 = new Visitor("VisitorA", 26, "VA", "VIP"    , 1);
        Visitor v2 = new Visitor("VisitorB", 27, "VB", "Regular", 1);
        Visitor v3 = new Visitor("VisitorC", 28, "VC", "VIP"    , 2);
        Visitor v4 = new Visitor("VisitorD", 29, "VD", "Regular", 3);
        Visitor v5 = new Visitor("VisitorE", 30, "VE", "VIP"    , 1);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Check in-history (VisitorA): " + ride.checkVisitorFromHistory(v1));
        System.out.println("History size: " + ride.numberOfVisitors());
        System.out.println("\nHistory (Iterator traversal):");
        ride.printRideHistory();
    }

    // ------------------------------------------------------------------------------------------------------
    // PART 4B — Sort history via Comparator (before/after)
    // ------------------------------------------------------------------------------------------------------
    public void partFourB() {
        banner("PART 4B: Sort Ride History (Comparator Demo)");
        Employee operator = new Employee("John", 40, "EMP003", "Operator", 6);
        Ride ride = new RollerCoasterRide("Twister", operator, 4);

        ride.addVisitorToHistory(new Visitor("Zara" , 22, "V001", "VIP"    , 1));
        ride.addVisitorToHistory(new Visitor("Adam" , 25, "V002", "Regular", 1));
        ride.addVisitorToHistory(new Visitor("Mia"  , 19, "V003", "VIP"    , 1));
        ride.addVisitorToHistory(new Visitor("Ben"  , 27, "V004", "Regular", 1));
        ride.addVisitorToHistory(new Visitor("Liam" , 23, "V005", "VIP"    , 1));

        System.out.println("Before sorting:");
        ride.printRideHistory();

        ride.sortRideHistory(new VisitorComparator()); // by name then ID

        System.out.println("\nAfter sorting:");
        ride.printRideHistory();
    }

    // -------------------------------------------------------------------------
    // PART 5 — Run one cycle (>=10 in queue) using maxRider capacity
    // -------------------------------------------------------------------------
    public void partFive() {
        banner("PART 5: Run One Cycle (>=10 in queue)");
        Employee operator = new Employee("Emily", 28, "EMP004", "Operator", 5);
        Ride ride = new FerrisWheelRide("Lazy Loop", operator, 3);

        for (int i = 1; i <= 10;  i++) {
            ride.addVisitorToQueue(new Visitor(
                    "QVisitor" + i, 18 + i, "QID" + i, (i % 2 == 0 ? "VIP" : "Regular"), 1));
        }

        System.out.println("Queue BEFORE run:");
        ride.printQueue();
        System.out.println();

        ride.runOneCycle();

        System.out.println("\nQueue AFTER run:");
        ride.printQueue();
        System.out.println("\nHistory AFTER run:");
        ride.printRideHistory();
    }

    // --------------------------------------------------------------------------------
    // PART 6 — Polymorphism showcase with Person reference
    // --------------------------------------------------------------------------------
    public void partSix() {
        banner("PART 6: Interface/Polymorphism Check");
        Person person = new Visitor("Visitor8", 28, "ID8", "VIP", 1);
        person.displayDetails();
    }

    // ----------------------------------------------------------
    // PART 7 — Start all rides once (manager)
    // ----------------------------------------------------------
    public void partSeven() {
        banner("PART 7: Start All Rides");
        RideManager manager = new RideManager();
        Employee operator = new Employee("Henry", 33, "EMP005", "Operator", 7);

        Ride r1 = new RollerCoasterRide("Dragon Twist", operator, 2);
        Ride r2 = new FerrisWheelRide("View Wheel", operator, 3);

        r1.addVisitorToQueue(new Visitor("Visitor9" , 19, "ID9" , "Regular", 1));
        r2.addVisitorToQueue(new Visitor("Visitor10", 20, "ID10", "Regular", 1));

        manager.addRide(r1);
        manager.addRide(r2);

        manager.startAllRides();
    }

    // ----------------------------------------------------------------------
    // PART 8 — Import history from a file
    // ----------------------------------------------------------------------
    public void partEight() {
        banner("PART 8: Import Ride History from File");
        Employee operator = new Employee("Danny", 32, "EMP777", "Operator", 5);
        Ride ride = new RollerCoasterRide("History Coaster", operator, 4);

        String filename = "ride_history.csv";
        ride.importRideHistory(filename);

        System.out.println(" Imported count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    // ----------------------------------------------------
    // INTERACTIVE SUPERVISOR UI
    // ----------------------------------------------------
    public void supervisorMenu() {
        banner("SUPERVISOR MENU");
        Scanner scanner = new Scanner(System.in);
        RideManager manager = new RideManager();
        Employee emp = new Employee("Supervisor Sam", 45, "EMP100", "Supervisor", 10);

        Ride crazy = new RollerCoasterRide("Crazy Coaster", emp, 4);
        Ride sky   = new FerrisWheelRide("Sky Wheel", emp, 5);

        crazy.addVisitorToQueue(new Visitor("Alice",  21, "CCQ001", "Regular", 1));
        crazy.addVisitorToQueue(new Visitor("Brian",  19, "CCQ002", "VIP",     2));
        crazy.addVisitorToQueue(new Visitor("Clara",  23, "CCQ003", "Regular", 1));

        sky.addVisitorToQueue(new Visitor("Dilan" ,    20, "SWQ001", "VIP"    ,     2));
        sky.addVisitorToQueue(new Visitor("Evelyn",   27, "SWQ002" , "Regular", 3));
        sky.addVisitorToQueue(new Visitor("Farah" ,    26, "SWQ003", "VIP"    ,     1));

        manager.addRide(crazy);
        manager.addRide(sky);

        int option = 0;
        do {
            System.out.println("""
                1. View All Rides
                2. View Ride Queues
                3. Add New Ride
                4. Add Visitor to Ride
                5. Start All Rides
                6. View Ride History
                7. Search Ride by Name
                8. Export ride history to file
                9. Sort Rides by Name
                10. Import ride history from file
                11. Exit
                """);
            System.out.print("Enter option: ");

            try {
                option = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (option) {
                case 1 -> manager.displayAllRides();
                case 2 -> manager.displayQueues();

                case 3 -> {
                    try {
                        System.out.print("Ride name: ");
                        String rname = scanner.nextLine().trim();
                        if (rname.isEmpty()) throw new IllegalArgumentException("Ride name cannot be empty.");

                        System.out.print("Ride type (1 = RollerCoaster, 2 = FerrisWheel): ");
                        int rtype = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Max riders per cycle: ");
                        int max = Integer.parseInt(scanner.nextLine().trim());
                        if (max < 1) throw new IllegalArgumentException("Max riders must be at least 1.");

                        System.out.print("Operator name: ");
                        String oname = scanner.nextLine().trim();
                        System.out.print("Operator age: ");
                        int oage = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Operator ID: ");
                        String oid = scanner.nextLine().trim();
                        System.out.print("Operator role: ");
                        String orole = scanner.nextLine().trim();
                        System.out.print("Operator years of exp: ");
                        int oexp = Integer.parseInt(scanner.nextLine().trim());

                        Employee op = new Employee(oname, oage, oid, orole, oexp);
                        Ride newRide = (rtype == 1)
                                ? new RollerCoasterRide(rname, op, max)
                                : (rtype == 2)
                                  ? new FerrisWheelRide(rname, op, max)
                                  : null;
                        if (newRide == null) throw new IllegalArgumentException("Invalid ride type. Use 1 or 2.");

                        manager.addRide(newRide);
                        System.out.println("Ride added: " + newRide.getRideName());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid numeric value entered.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(" " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.print("Enter ride name: ");
                    String rideName = scanner.nextLine();
                    Ride foundRide = manager.findRideByName(rideName);
                    if (foundRide == null) {
                        System.out.println("Ride not found.");
                        break;
                    }

                    try {
                        System.out.print("Visitor Name: ");
                        String name = scanner.nextLine().trim();
                        if (!name.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("Name must contain only letters and spaces.");
                        }

                        System.out.print("Age (6–80): ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        if (age < 6 || age > 80) {
                            throw new IllegalArgumentException("Age must be between 6 and 80.");
                        }

                        System.out.print("ID (must be unique): ");
                        String id = scanner.nextLine().trim();
                        if (id.isEmpty()) {
                            throw new IllegalArgumentException("ID cannot be empty.");
                        }
                        boolean duplicateId = false;
                        for (Visitor v : foundRide.getRideHistory()) {
                            if (v.getId().equalsIgnoreCase(id)) { duplicateId = true; break; }
                        }
                        for (Visitor v : foundRide.getVisitorQueue()) {
                            if (v.getId().equalsIgnoreCase(id)) { duplicateId = true; break; }
                        }
                        if (duplicateId) throw new IllegalArgumentException("Duplicate ID! This ID already exists for this ride.");

                        System.out.print("Ticket (VIP/Regular): ");
                        String ticket = scanner.nextLine().trim();
                        if (!(ticket.equalsIgnoreCase("VIP") || ticket.equalsIgnoreCase("Regular"))) {
                            throw new IllegalArgumentException("Ticket type must be either VIP or Regular.");
                        }

                        System.out.print("Group Size (1–5): ");
                        int group = Integer.parseInt(scanner.nextLine().trim());
                        if (group < 1 || group > 5) {
                            throw new IllegalArgumentException("Group size must be between 1 and 5.");
                        }

                        foundRide.addVisitorToQueue(new Visitor(name, age, id, ticket, group));
                        System.out.println("Visitor added successfully.");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter numeric values for age and group size.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(" " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println(" Unexpected error: " + e.getMessage());
                    }
                }

                case 5 -> manager.startAllRides();

                case 6 -> {
                    for (Ride r : manager.getAllRides()) {
                        System.out.println("\n Ride: " + r.getRideName());
                        r.printRideHistory();
                    }
                }

                case 7 -> {
                    System.out.print("🔍 Enter ride name to search: ");
                    String search = scanner.nextLine();
                    Ride r = manager.findRideByName(search);
                    if (r == null) System.out.println("No ride found with that name.");
                    else {
                        System.out.println("Found Ride: " + r.getRideName());
                        System.out.println("Operator: " + r.getOperator().getName());
                    }
                }

                case 8 -> {
                    System.out.print("Enter ride name to export history: ");
                    String exportRideName = scanner.nextLine();
                    System.out.print("Enter filename (e.g., ride_history.csv): ");
                    String filename = scanner.nextLine();
                    Ride exportRide = manager.findRideByName(exportRideName);
                    if (exportRide != null) exportRide.exportRideHistory(filename);
                    else System.out.println("Ride not found with that name.");
                }

                case 9 -> { manager.sortRidesByName(); System.out.println(" Rides sorted by name."); }

                case 10 -> {
                    System.out.print("Enter ride name to import into: ");
                    String importRideName = scanner.nextLine();
                    Ride importRide = manager.findRideByName(importRideName);
                    if (importRide == null) { System.out.println("Ride not found with that name."); break; }
                    System.out.print("Enter CSV filename to import (e.g., Crazy Coaster_history.csv): ");
                    String importFile = scanner.nextLine();
                    importRide.importRideHistory(importFile);
                }

                case 11 -> System.out.println(" Goodbye.");

                default -> System.out.println(" Invalid option.");
            }

            if (option != 11) { divider(); }
        } while (option != 11);

        scanner.close();
    }

    // =========[ Console styling helpers ]=========
    private static final String RESET        = "\u001B[0m";
    private static final String BOLD         = "\u001B[1m";
    private static final String BRIGHT_WHITE = "\u001B[97m";
    private static final String BRIGHT_CYAN  = "\u001B[96m";

    private static final String H  = "─";
    private static final String V  = "│";
    private static final String TL = "┌";
    private static final String TR = "┐";
    private static final String BL = "└";
    private static final String BR = "┘";

    private static final int BANNER_MIN = 38;
    private static final int BANNER_MAX = 96;
    private static final int BANNER_PAD = 2;

    private int lastBannerWidth = 60;

    private int terminalWidth() {
        try {
            String cols = System.getenv("COLUMNS");
            if (cols != null) {
                int c = Integer.parseInt(cols.trim());
                if (c >= 40 && c <= 240) return c;
            }
        } catch (Exception ignored) {}
        return 100;
    }

    private static String stripAnsi(String s) {
        return s.replaceAll("\\u001B\\[[;\\d]*m", "");
    }

    private void banner(String title) {
        String clean = stripAnsi(title);
        int termInnerCap = Math.max(40, terminalWidth() - 4);
        int innerCap = Math.min(BANNER_MAX, termInnerCap);

        int contentNeeded = clean.length() + (BANNER_PAD * 2);
        int innerWidth = Math.max(BANNER_MIN, Math.min(innerCap, contentNeeded));

        int maxText = innerWidth - (BANNER_PAD * 2);
        if (clean.length() > maxText) {
            clean = clean.substring(0, Math.max(0, maxText - 1)) + "…";
        }

        int padLeft = (innerWidth - clean.length()) / 2 + BANNER_PAD;
        int padRight = innerWidth - clean.length() - padLeft;

        String top = BRIGHT_CYAN + BOLD + TL + H.repeat(innerWidth) + TR + RESET;
        String middle = BRIGHT_CYAN + BOLD + V + " ".repeat(padLeft) + RESET
                + BRIGHT_WHITE + BOLD + clean + RESET
                + BRIGHT_CYAN + BOLD + " ".repeat(padRight) + V + RESET;
        String bottom = BRIGHT_CYAN + BOLD + BL + H.repeat(innerWidth) + BR + RESET;

        System.out.println();
        System.out.println(top);
        System.out.println(middle);
        System.out.println(bottom);

        lastBannerWidth = innerWidth;
    }

    private void divider() {
        System.out.println("\n" + BRIGHT_CYAN + H.repeat(lastBannerWidth + 2) + RESET + "\n");
    }
}
