package team4.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private String username;
    private String password;

    public List<Post> userPosts = new ArrayList<>();

    //da capire come usarla
    //public List <User> friends = new ArrayList<>();

    public User(String name, String surname, String username, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

}
