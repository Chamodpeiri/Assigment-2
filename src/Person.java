//Student name - Chamod gimhana peiris
//Student ID - 24723297
//person.java
public abstract class Person {

    //these are the common details every person will have
    protected String name;         //person's name
    protected int age;             //person's age
    protected String id;           //unique ID for the person

    //empty constructor - allows creating a Person object without setting details yet
    public Person() {}

    //constructor to create a Person with name, age, and id
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //getter method to return the person's name
    public String getName() {
        return name;
    }

    //getter method to return the person's age
    public int getAge() {
        return age;
    }

    //getter method to return the person's ID
    public String getId() {
        return id;
    }

    //abstract method - subclasses must provide their own way to display details
    public abstract void displayDetails();
}
