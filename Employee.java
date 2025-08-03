/**
 * Represents an employee (ride operator) at the theme park.
 */
public class Employee extends Person {
    private String position;
    private int experienceYears;

    public Employee() {}

    public Employee(String name, int age, String id, String position, int experienceYears) {
        super(name, age, id);
        this.position = position;
        this.experienceYears = experienceYears;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
}
