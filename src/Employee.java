public class Employee {
    private String name;
    private int age;
    private String employeeId;
    private String role;
    private int yearsOfExperience;

    public Employee(String name, int age, String employeeId, String role, int yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.employeeId = employeeId;
        this.role = role;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void displayDetails() {
        System.out.println("👨‍🔧 Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Role: " + role);
        System.out.println("Experience: " + yearsOfExperience + " years");
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s, Age: %d) - Role: %s, %d years experience", 
                              name, employeeId, age, role, yearsOfExperience);
    }
}
