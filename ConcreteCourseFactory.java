import java.util.Scanner;

public class ConcreteCourseFactory implements CourseFactory {
    @Override
    public Course createCourse( String name, String number, Tutor teacher, Lecturer lecturer) {
        int maxStudents;
        String type;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the type of course (seminar, elective, mandatory): ");
             type = scanner.nextLine();
            if (type.equals("seminar") || type.equals("elective") || type.equals("mandatory")) {
                break;
            } else {
                System.out.println("Invalid course type. Please try again.");
            }
        }
        while (true) {
            System.out.println("Enter the number of students: ");
             maxStudents = scanner.nextInt();
            if (maxStudents > 0) {
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid number of students. Please try again.");
            }
        }
        return switch (type) {
            case "seminar" -> new SeminarCourse(name, number,teacher,lecturer,maxStudents);
            case "elective" -> new ElectiveCourse(name, number,teacher,lecturer,maxStudents);
            case "mandatory" -> new MandatoryCourse(name, number,teacher,lecturer,maxStudents);
            default -> null;
        };
    }
}