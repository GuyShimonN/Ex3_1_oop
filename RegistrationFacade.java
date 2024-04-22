public class RegistrationFacade {
    private final RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

    public void registerStudentToCourse(Long studentId, String courseId) {
        Student student = (Student) registrationSystem.getUser(studentId);
        Course course = registrationSystem.getCourseByNumber(courseId);
        if (student != null && course != null) {
            student.registerToCourse(course);
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public void unregisterStudentFromCourse(long studentId, String courseId) {
        Student student = (Student) registrationSystem.getUser(studentId);
        Course course = registrationSystem.getCourseByNumber(courseId);
        if (student != null && course != null) {
            student.unregisterFromCourse(course);
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public void listAllAvailableCourses() {
        for (Course course : registrationSystem.getCourses()) {
            if (course.getNumberOfStudents() < course.getMaxStudents()) {
                System.out.println(course.toString());
            }
        }
    }
}
