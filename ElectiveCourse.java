public class ElectiveCourse extends Course {
    public ElectiveCourse(String name, String number,Tutor teacher,Lecturer lecturer,int maxStudents) {
        super(name, number, CourseType.ELECTIVE,teacher,lecturer,maxStudents);
    }

    // Other methods specific to ElectiveCourse
}
