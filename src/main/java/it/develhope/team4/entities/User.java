package it.develhope.team4.entities;

import it.develhope.team4.enums.PrivacyType;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class User {

    private String userId;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int age;
    private String email;
    private String username;
    private String telephone;
    private String password;
    private boolean isBanned;
    private List<Post> userPosts = new ArrayList<>();
    private List <String> friends = new ArrayList<>();
    //private List <Post> homePagePosts = new ArrayList<>();

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
    public static User register(String name, String surname, LocalDate birthDate, String email, String username, String telephone, String password){
        return new User(name, surname, birthDate, email, username, telephone, password);
    }
    public static void loginUsername(String username, String password, boolean twoFactorsAuthentication){
        //nella tabella del database deve cercare nella colonna username se questo esiste
        //se esiste prendi l'id dell'user e vedi se la password di quell'id corrisponde
        //deve gestire se username non c'è e se password sbagliata
        //come usare la twoFactorsAuthentication
    }
    public static void loginEmail(String email, String password, boolean twoFactorsAuthentication){
        //lo stesso che con loginUsername
    }
    public static void loginTelephone(String telephone, String password, boolean twoFactorsAuthentication){
        //lo stesso che con loginUsername
    }
    public Post createPost(String postDescription, String urlImg, PrivacyType privacy){
        userPosts.add(new Post(this.userId, urlImg, postDescription, privacy));
        return new Post(this.userId, urlImg, postDescription, privacy);
    }
    public void requestFriendship(String userId){
        //implementazione?
    }

    public void acceptFriend(String userId){
        //implementazione?
    }

    public void declineFriend(){
        //implementazione?
    }
    public void addFriend(String idFriend){
        friends.add(idFriend);
    }
    public void removeFriend(String idFriend){
        friends.remove(idFriend);
    }
    public void modifyPassword(String newPassword){

    }
    public void modifyUsername(){

    }
    public void modifyEmail(){

    }

    public void deleteUser(){

    }

}
