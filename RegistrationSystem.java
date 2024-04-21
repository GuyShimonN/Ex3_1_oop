import java.util.ArrayList;
import java.util.List;

// RegistrationSystem is a singleton class that manages the registration of users and courses.
public class RegistrationSystem {
    private static RegistrationSystem instance= new RegistrationSystem();
    private List<User> activeUsers ;
    private List<Course> courses;
    private final int MAX_ACTIVE = 100;
    public static boolean isFull = false;


    private RegistrationSystem() {
        this.activeUsers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public static RegistrationSystem getInstance() {
        if (instance == null) {
            instance = new RegistrationSystem();
        }
        return instance;
    }
    public void addUser(User user) {
        if (activeUsers.size() < MAX_ACTIVE) {
            activeUsers.add(user);
        } else {
            System.out.println("The system is full. Please try again later.");
            isFull = true;
        }
    }
    public void removeUser(User user) {
        activeUsers.remove(user);
        isFull = false;
    }

    public Course[] getCourses() {
//        System.out.println("Courses are listed below:");
//        for (Course course : courses) {
//            System.out.println(course.getName());
//        }
        return courses.toArray(new Course[0]);
    }

    public void addCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getName().equals(course.getName())) {
                System.out.println("A course with this name already exists.");
                return;
            }
        }
        courses.add(course);
    }


    // Other methods for registration system
}