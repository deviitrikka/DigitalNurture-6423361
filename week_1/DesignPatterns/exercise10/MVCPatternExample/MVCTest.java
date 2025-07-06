package exercise10.MVCPatternExample;


public class MVCTest {
    public static void main(String[] args) {
        // Step 1: Create Model
        Student student = new Student("S101", "Jake Humphry", "A");

        // Step 2: Create View
        StudentView view = new StudentView();

        // Step 3: Create Controller
        StudentController controller = new StudentController(student, view);

        // Step 4: Display initial details
        System.out.println("Initial Student Record:");
        controller.updateView();

        // Step 5: Update model data through controller
        controller.setStudentName("Jake Williams");
        controller.setStudentGrade("A+");

        // Step 6: Display updated details
        System.out.println("Updated Student Record:");
        controller.updateView();
    }
}
