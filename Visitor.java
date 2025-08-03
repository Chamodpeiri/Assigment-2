public class Visitor extends Person {
    private String ticketType;
    private int groupSize;

    public Visitor() {}

    public Visitor(String name, int age, String id, String ticketType, int groupSize) {
        super(name, age, id);
        this.ticketType = ticketType;
        this.groupSize = groupSize;
    }

    public String getTicketType() { return ticketType; }
    public int getGroupSize() { return groupSize; }

    public void setTicketType(String ticketType) { this.ticketType = ticketType; }
    public void setGroupSize(int groupSize) { this.groupSize = groupSize; }

    @Override
    public String toString() {
        return getName() + " | Age: " + getAge() + " | ID: " + getId() +
               " | Ticket: " + ticketType + " | Group: " + groupSize;
    }
}
