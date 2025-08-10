public class Visitor extends Person {
    private String ticketType;
    private int groupSize;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String id, String ticketType, int groupSize) {
        super(name, age, id);
        this.ticketType = ticketType;
        this.groupSize = groupSize;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("Visitor: " + getName() + " | Age: " + getAge() + " | ID: " + getId() + 
                           " | Ticket: " + ticketType + " | Group: " + groupSize);
    }
}
