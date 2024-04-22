import java.util.HashSet;

public abstract class User {
    protected Boolean isActive;
    protected String password;
    protected String name;
    protected final Long id;
    private static HashSet<Long> ids = new HashSet<>();

    public User(String name, Long id, String password) {
        if (ids.contains(id)) {
            throw new IllegalArgumentException("User ID must be unique");
        }
        ids.add(id);
        this.name = name;
        this.id = id;
        this.password = password;
        RegistrationSystem.getInstance().Add_user(this);
        if (RegistrationSystem.isFull) {
            isActive = false;
            System.out.println(name + " with ID " + id + " the registration Completed but the system is full please try later to connect.");
        } else {
            RegistrationSystem.getInstance().addUser(this);
            isActive = true;
        }
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void login(  String password) {
        if (this.password.equals(password)) {

            if (!RegistrationSystem.isFull) {
                System.out.println(name + " with ID " + id + " is logged in.");
                RegistrationSystem.getInstance().addUser(this);
                this.isActive = true;
            } else {
                System.out.println("the system is full please try later to connect.");
            }
        } else {
            System.out.println("Invalid password. Please try again.");
        }
    }
    public void logout() {
        if (!isActive) {
            System.out.println("User is not logged in.");
            return;
        }
        System.out.println(name + " with ID " + id + " is logged out.");
        RegistrationSystem.getInstance().removeUser(this);
        this.isActive = false;
    }


}