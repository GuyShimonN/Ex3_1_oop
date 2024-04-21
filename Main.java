//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
    Student student1 = new Student("guy", 1L, "1234");
    Student student2 = new Student("daniel", 2L, "1234");
    Student student3 = new Student("shacar", 3L, "1234");
    Lecturer lecturer1 = new Lecturer("Dr. or", 4L, "1234");
    Lecturer lecturer2 = new Lecturer("Dr. eran", 5L, "1234");
    Tutor tutor1 = new Tutor("Mr. Mohamed", 6L, "1234");
    Tutor tutor2 = new Tutor("Mr. Mahmoud", 7L, "1234");
    lecturer2.createCourse("Math", "101", tutor1, lecturer2);
    student2.listAvailableCourses();

    }
}
