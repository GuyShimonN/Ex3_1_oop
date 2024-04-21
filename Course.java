import java.util.HashSet;

public abstract class Course implements Observable{
    private static final HashSet<String> courseNames = new HashSet<>();
    private static final HashSet<String> courseNumbers = new HashSet<>();
    private final HashSet<Observer> observers = new HashSet<>();
    private final HashSet<Student> students = new HashSet<>();
    private final HashSet<Tutor> teacher = new HashSet<>();
    private final String name;
    private String number;
    private CourseType courseType;
    private int maxStudents;

    public Course(String name, String number, CourseType courseType, Tutor teacher,Lecturer lecturer,int maxStudents) {
        if (courseNames.contains(name)) {
            throw new IllegalArgumentException("Course name must be unique");
        }
        if (courseNumbers.contains(number)) {
            throw new IllegalArgumentException("Course number must be unique");
        }
        courseNames.add(name);
        courseNumbers.add(number);
        this.name = name;
        this.number = number;
        this.courseType = courseType;
        this.maxStudents = maxStudents;
        RegistrationSystem.getInstance().addCourse(this);
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public CourseType getCourseType() {
        return courseType;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public int getNumberOfStudents() {
        return students.size();
    }
    // Other methods specific to Course


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String massage) {
        for (Observer o : observers) {
            o.update("A spot has become available in a course you are interested in."+name);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        if (!students.contains(student)) {
            return;
        }
        if (students.size() == maxStudents) {
            notifyObservers("A spot has become available in a course you are interested in."+this.toString());
        }
        students.remove(student);
    }

    // Other methods for course
}