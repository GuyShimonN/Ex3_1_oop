import java.util.HashSet;
import java.util.Scanner;

public class Student extends User implements Observer {
    protected HashSet<Course> courses = new HashSet<>();
    public Student(String name, Long id, String password) {
        super(name , id, password);
    }

    @Override
    public void update(String message) {
        System.out.println("A spot has become available in a course you are interested in.");
    }
    public void registerToCourse(Course course) {
      if (!isActive) {
            System.out.println("You are not logged in.");
            return;
        }
        if (courses.contains(course)) {
            System.out.println("You are already registered to this course.");
            return;
        }
        if (course.getNumberOfStudents() >= course.getMaxStudents()) {
            System.out.println("The course is full.");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Would you like to be added to the waiting list? (yes/no)");
                String answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    course.registerObserver(this);
                    break;
                } else if (answer.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
            scanner.close();
            return;
        }
        courses.add(course);
        course.addStudent(this);
        System.out.println("You have successfully registered to " + course.getName());
    }
    public void unregisterFromCourse(Course course) {
        if (!isActive) {
            System.out.println("You are not logged in.");
            return;
        }
        if (!courses.contains(course)) {
            System.out.println("You are not registered to this course.");
            return;
        }
        courses.remove(course);
        course.removeStudent(this);
        System.out.println("You have successfully unregistered from " + course.getName());
    }
    public void listCourses() {
        if (!isActive) {
            System.out.println("You are not logged in.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("You are not registered to any courses.");
            return;
        }
        System.out.println("You are registered to the following courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
    public void listAvailableCourses() {
        if (!isActive) {
            System.out.println("You are not logged in.");
            return;
        }

        for (Course course : RegistrationSystem.getInstance().getCourses()) {
            if (course.getNumberOfStudents() < course.getMaxStudents()) {
                System.out.println(course.getName());
            }
        }
    }
    public void listFullCourses() {
        if (!isActive) {
            System.out.println("You are not logged in.");
            return;
        }
        for (Course course : RegistrationSystem.getInstance().getCourses()) {
            if (course.getNumberOfStudents() >= course.getMaxStudents()) {
                System.out.println(course.getName());
            }
        }
    }
    public String toString() {
        return (name + " with ID " + id+ " is a student and is " + (isActive ? "active" : "inactive") + ".");
    }
    public String getNameofCorses() {
        String names = "";
        for (Course course : courses) {
            names += course.getName() + " ";
        }
        return names;
    }



    // Other methods specific to Student
}