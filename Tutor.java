public class Tutor extends Student {
    public Tutor(String name, Long id, String password) {
        super(name, id, password);
    }
    public Course createCourse(String name, String number, Tutor teacher, Lecturer lecturer) {
        ConcreteCourseFactory factory = new ConcreteCourseFactory();
        return factory.createCourse(name, number, teacher, lecturer);
    }


    // Other methods specific to Tutor
}
