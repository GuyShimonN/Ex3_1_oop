import java.util.HashSet;

public abstract class Course implements Observable{

    private static final HashSet<String> courseNumbers = new HashSet<>();
    private final HashSet<Observer> observers = new HashSet<>();
    private final HashSet<Student> students = new HashSet<>();
    private Tutor teacher ;
    private Lecturer lecturer;
    private final String name;
    private String number;
    private CourseType courseType;
    private int maxStudents;

    public Course(String name, String number, CourseType courseType, Tutor teacher,Lecturer lecturer,int maxStudents) {
        if (courseNumbers.contains(number)) {
            throw new IllegalArgumentException("Course number must be unique");
        }
        this.lecturer= lecturer;
        this.teacher = teacher;
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
            o.update("A spot has become available in a course you are interested in."+toString());
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
    public String toString() {
        return getCourseType()+" in "+ name + " number: " + number;
    }

    // Other methods for course
}