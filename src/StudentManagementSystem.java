import java.util.ArrayList;
import java.util.Scanner;

// Student Data Model
class Student {
    private String id;
    private String name;
    private String course;

    public Student(String id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-15s |", id, name, course);
    }
}

// Logic Handler
class ManagementLogic {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String id, String name, String course) {
        students.add(new Student(id, name, course));
        System.out.println("✅ Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students registered yet.");
            return;
        }
        System.out.println("\n---------------------------------------------------------");
        System.out.println("| ID         | Name                 | Course          |");
        System.out.println("---------------------------------------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("---------------------------------------------------------");
    }

    public void removeStudent(String id) {
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("🗑️ Student with ID " + id + " removed.");
        } else {
            System.out.println("❌ Student ID not found.");
        }
    }
}

// Main Class
public class StudentManagementSystem {
    public static void main(String[] args) {
        ManagementLogic logic = new ManagementLogic();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n🎓 STUDENT DATABASE SYSTEM");
            System.out.println("1. Register Student");
            System.out.println("2. View All Records");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    logic.addStudent(id, name, course);
                    break;
                case "2":
                    logic.viewStudents();
                    break;
                case "3":
                    System.out.print("Enter ID to delete: ");
                    String delId = sc.nextLine();
                    logic.removeStudent(delId);
                    break;
                case "4":
                    System.out.println("Exiting... Good Bye!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}