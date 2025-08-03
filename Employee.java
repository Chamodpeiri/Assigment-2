public class Employee extends Person {
    private String position;
    private String shift;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String id, String position, String shift) {
        super(name, age, id);
        this.position = position;
        this.shift = shift;
    }

    public String getPosition() {
        return position;
    }

    public String getShift() {
        return shift;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return getName() + " (" + position + ", " + shift + ")";
    }
}
