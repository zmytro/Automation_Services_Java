package Entities;
//POJO
public class User {
    private String login;
    private int id;
    private int followers;
    private String name;

    public String getLogin(){
        return login;
    }
    public int getId(){
        return id;
    }
    public int getFollowers(){
        return followers;
    }

    public String getName() {
        return name;
    }
}
