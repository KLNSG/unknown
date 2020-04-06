package user.pojo;

public class User {
    private Integer id;
    private String name;
    private  String Password;

    public User() {
    }

    public User(Integer id, String name, String pssword) {
        id = id;
        this.name = name;
        Password = pssword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String pssword) {
        Password = pssword;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", Pssword='" + Password + '\'' +
                '}';
    }
}
