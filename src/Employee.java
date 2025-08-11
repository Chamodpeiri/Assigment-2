//Student name - Chamod gimhana peiris
//Student ID - 24723297
//Employee.java
public class Employee {

    //attributes to store employee details
    private String name;
    private int age;
    private String employeeId;
    private String role;
    private int yearsOfExperience;

    //constructor to set all employee details when creating an object
    public Employee(String name, int age, String employeeId, String role, int yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.employeeId = employeeId;
        this.role = role;
        this.yearsOfExperience = yearsOfExperience;
    }

    //getter method to return the employee's name
    public String getName() {
        return name;
    }

    //getter method to return the employee's age
    public int getAge() {
        return age;
    }

    //getter method to return the employee's ID
    public String getEmployeeId() {
        return employeeId;
    }

    //getter method to return the employee's job role
    public String getRole() {
        return role;
    }

    //getter method to return how many years the employee has worked
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    //method to display the employee's details in a clear format
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Role: " + role);
        System.out.println("Experience: " + yearsOfExperience + " years");
    }

    // toString method to return the employee's details as a single text line
    @Override
    public String toString() {
        return String.format("%s (ID: %s, Age: %d) - Role: %s, %d years experience", 
                              name, employeeId, age, role, yearsOfExperience);
    }
}
