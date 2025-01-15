// JavaBean Class (Student.java)
public class prog9bean {
    // Private fields (attributes)
    private String name;
    private int age;

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        if (age > 0) {  // A basic validation
            this.age = age;
        } else {
            System.out.println("Invalid age value.");
        }
    }
    public static void main(String[] args) {
        // Creating an instance of the Student JavaBean
        prog9bean student = new prog9bean();

        // Using setter methods to set values
        student.setName("John Doe");
        student.setAge(20);

        // Using getter methods to get values
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }

}

// Main Class to test the JavaBean (Main.java)


