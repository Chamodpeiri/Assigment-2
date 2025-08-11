//Student name - Chamod gimhana peiris
//Student ID - 24723297
//visitor class extends Person, meaning it inherits name, age, and ID from Person
public class Visitor extends Person {
    //type of ticket the visitor has (VIP or Regular)
    private String ticketType;
    //no of people in the visitor's group
    private int groupSize;

    //default constructor (no values given)
    public Visitor() {
        super();                                     //calls Person's default constructor
    }

    //constructor with all visitor details
    public Visitor(String name, int age, String id, String ticketType, int groupSize) {
        super(name, age, id);                        //calls Person constructor to set name, age, and ID
        this.ticketType = ticketType;                // sets the ticket type for the visitor
        this.groupSize = groupSize;                  // sets the group size for the visitor
    }

    //to get method to read the ticket type
    public String getTicketType() {
        return ticketType;
    }

    //to set method to change the ticket type
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    //to get method to read the group size
    public int getGroupSize() {
        return groupSize;
    }

    //set method to change the group size
    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    //overrides the displayDetails() method from Person to also include ticket type and group size
    @Override
    public void displayDetails() {
        System.out.println("Visitor: " + getName() + " | Age: " + getAge() + " | ID: " + getId() + 
                           " | Ticket: " + ticketType + " | Group: " + groupSize);
    }
}
