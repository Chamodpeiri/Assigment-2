import java.util.Comparator;

/**
 * Comparator for sorting visitors by age, then name.
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) return ageCompare;
        return v1.getName().compareTo(v2.getName());
    }
}
