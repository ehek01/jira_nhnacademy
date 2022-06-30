package day04;

public class User extends Account {
    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.isAdmin = false;
        this.failCount =0;
    }
}
