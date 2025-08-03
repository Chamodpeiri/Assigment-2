import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    public int compare(Visitor v1, Visitor v2) {
        int nameCompare = v1.getName().compareTo(v2.getName());
        if (nameCompare != 0) return nameCompare;
        return Integer.compare(v1.getGroupSize(), v2.getGroupSize());
    }
}



