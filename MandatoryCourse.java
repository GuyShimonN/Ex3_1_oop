public class MandatoryCourse extends Course {
    public MandatoryCourse(String name, String number, Tutor teacher, Lecturer lecturer, int maxStudents ) {
        super(name, number, CourseType.MANDATORY ,teacher,lecturer,maxStudents);
    }

    // Other methods specific to MandatoryCourse
}
