package it.develhope.team4.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    String userId;
    String name;
    String surname;
    LocalDate birthDate;
    int age;
    String email;
    String username;
    String telephone;
    String password;
    boolean isBanned;
    List<Post> userPosts = new ArrayList<>();
    List <User> friends = new ArrayList<>();
    //List <Post> homePagePosts = new ArrayList<>();

    public User(String name, String surname, LocalDate birthDate, String email, String username, String telephone, String password){
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
        this.email = email;
        this.username = username;
        this.telephone = telephone;
        this.password = password;
        this.isBanned = false;
    }
    static void register()
    static void loginUsername(String username, String password)
    static void loginEmail(String username, String password)
    static void loginTelephone(String username, String password)
    Post createPost(String postDescription, String urlImg/urlVideo) (List di url images?)
    void requestFriendship(String userId)
    boolean acceptFriend(boolean acceptance, String idFriend)
    void removeFriend(String idFriend)
    void modifyPassword()
    void modifyUsername()
    void modifyEmail()


}
