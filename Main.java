//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RegistrationFacade registrationFacade = new RegistrationFacade();

        // Create users
        Student student1 = new Student("guy", 1L, "1234");
        Student student2 = new Student("daniel", 2L, "1234");
        Student student3 = new Student("shacar", 3L, "1234");
        Lecturer lecturer1 = new Lecturer("Dr. or", 4L, "1234");
        Lecturer lecturer2 = new Lecturer("Dr. eran", 5L, "1234");
        Tutor tutor1 = new Tutor("Mr. Mohamed", 6L, "1234");
        Tutor tutor2 = new Tutor("Mr. Mahmoud", 7L, "1234");

        // Create courses

        Course course = lecturer2.createCourse("Math", "101", tutor1, lecturer2);
        Course course2 = lecturer1.createCourse("oop", "102", tutor2, lecturer1);
//        Course course4 = tutor1.createCourse("lin", "104", tutor2, lecturer1);
//        Course course5 = tutor2.createCourse("java", "105", tutor1, lecturer2);
        System.out.println("try to create the same course");
        Course course1 = lecturer1.createCourse("Math", "101", tutor1, lecturer2);
        System.out.print(course1 == course);
        System.out.println(" its the same course");
        student2.listAvailableCourses();

        // Register students to courses
        registrationFacade.registerStudentToCourse(1L, "101");
        registrationFacade.registerStudentToCourse(2L, "101");


        // try to register to full course
        student3.registerToCourse(course);

        // try to do an action without login
        student1.logout();
        registrationFacade.registerStudentToCourse(1L, "102");
        registrationFacade.unregisterStudentFromCourse(1L, "101");
        //  login
        student1.login("1234");

        // Unregister student from course
        registrationFacade.unregisterStudentFromCourse(1L, "101");
        registrationFacade.registerStudentToCourse(3L, "101");

    }
}
