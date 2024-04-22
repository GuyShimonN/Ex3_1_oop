import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// RegistrationSystem is a singleton class that manages the registration of users and courses.
public class RegistrationSystem {
    private static RegistrationSystem instance= new RegistrationSystem();
    private int numOfactiveUsers; ;
    private List<User>allUsers;
    private Map<String, Course> courses;
    private final int MAX_ACTIVE = 100;
    public static boolean isFull = false;


    private RegistrationSystem() {
        this.numOfactiveUsers = numOfactiveUsers;
        this.allUsers = new ArrayList<>();
        numOfactiveUsers=0;
        this.courses = new HashMap<>();    }

    public static RegistrationSystem getInstance() {
        if (instance == null) {
            instance = new RegistrationSystem();
        }
        return instance;
    }
    public void addUser(User user) {
        if (numOfactiveUsers < MAX_ACTIVE) {
            numOfactiveUsers++;
        } else {
            System.out.println("The system is full. Please try again later.");
            isFull = true;
        }
    }
    public void removeUser(User user) {
       if (user.getIsActive() ){
           numOfactiveUsers--;
           isFull = false;
       }
    }

    public Course[] getCourses() {
//        System.out.println("Courses are listed below:");
//        for (Course course : courses) {
//            System.out.println(course.getName());
//        }
        return courses.values().toArray(new Course[0]);
    }

    public void addCourse(Course course) {
        if (courses.containsKey(course.getNumber())) {
            System.out.println("A course with this number already exists.");
            return;
        }
        courses.put(course.getNumber(), course);
    }
    public Course getCourseByNumber(String number) {
        return courses.get(number);
    }

    public User getUser(long studentId) {
        for (User user : allUsers) {
            if (user.getId() == studentId) {
                return user;
            }
        }
        return null;

    }

    public void Add_user(User user) {
        allUsers.add(user);
    }
    public Student createStudent(String name, Long id, String password) {
        return new Student(name, id, password);
    }
    public Tutor createTutor(String name, Long id, String password) {
        return new Tutor(name, id, password);
    }
    public Lecturer createLecturer(String name, Long id, String password) {
        return new Lecturer(name, id, password);
    }

    // Other methods for registration system
}