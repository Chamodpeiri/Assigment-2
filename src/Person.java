public abstract class Person {
    protected String name;
    protected int age;
    protected String id;

    public Person() {}

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    // 👇 ADD THIS LINE
    public abstract void displayDetails();
}
