// VisitorComparator.java
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor a, Visitor b) {
        // 1) ticket type (VIP/Regular), case-insensitive
        int byTicket = a.getTicketType().compareToIgnoreCase(b.getTicketType());
        if (byTicket != 0) return byTicket;

        // 2) then by name, case-insensitive
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
