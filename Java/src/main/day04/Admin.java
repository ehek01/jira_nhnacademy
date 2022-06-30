package day04;

public class Admin extends Account {
    public Admin(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.isAdmin = true;
    }
}
