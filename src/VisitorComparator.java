//Student name - Chamod gimhana peiris
//Student ID - 24723297
//visitorComparator.java
import java.util.Comparator;

// this class is used to compare two Visitor objects so we can sort them
// based on ticket type first, and then by name
public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor a, Visitor b) {
        // to Compare ticket type (VIP or Regular) without caring about upper/lower case
        // if the ticket types are different, sorting will be based on ticket type
        int byTicket = a.getTicketType().compareToIgnoreCase(b.getTicketType());
        if (byTicket != 0) return byTicket; // If not equal, return the result here

        // if ticket type is the same, compare by the visitor's name (also ignoring case)
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
