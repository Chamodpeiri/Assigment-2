/**
 * Abstract class representing a person in the system.
 * Used as a base class for Employee and Visitor.
 */
public abstract class Person {
    private String name;
    private int age;
    private String id;

    public Person() {}

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
