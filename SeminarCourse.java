public class SeminarCourse extends Course {
    public SeminarCourse(String name, String number, Tutor teacher, Lecturer lecturer, int maxStudents) {
        super(name, number, CourseType.SEMINAR, teacher, lecturer, maxStudents);
    }

    // Other methods specific to SeminarCourse
}

