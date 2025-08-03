/**
 * Represents a visitor to the theme park.
 */
public class Visitor extends Person {
    private String ticketType;
    private int groupNumber;

    public Visitor() {}

    public Visitor(String name, int age, String id, String ticketType, int groupNumber) {
        super(name, age, id);
        this.ticketType = ticketType;
        this.groupNumber = groupNumber;
    }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public int getGroupNumber() { return groupNumber; }
    public void setGroupNumber(int groupNumber) { this.groupNumber = groupNumber; }

    @Override
    public String toString() {
        return getName() + " | Age: " + getAge() + " | ID: " + getId() +
               " | Ticket: " + ticketType + " | Group: " + groupNumber;
    }
}
