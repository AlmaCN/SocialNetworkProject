package it.develhope.team4.entities;

import it.develhope.team4.enums.PrivacyType;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;





@Data
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
        /**Mock loginQuery*/
        /*
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement statement = con.createStatement();
            String query = "Select DBpassword from DBuserName";
            if(password.equals(DBpassword){
            //fai continuare il login process
            }else{
            //restituisci un errore
            }
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
         */

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

    /** */
    public void requestFriendship(String userId){
        //IO clicco il tasto che invia questa richiesta, quindi invio il mio ID?

        //implementazione?
    }
    /** */
    public void acceptFriend(String friendThatAskedToBeFriendUserId){
        friends.add(friendThatAskedToBeFriendUserId);
        //implementazione?
    }
    /** */
    public void declineFriend(){
        //implementazione?
        //solo un messaggio di declinazione della richiesta? si puo' gestire solo frontend credo
    }


    /** */
    //io clicco tasto "addFriend"
    public void addFriend(String MyidFriend){
        //mando il mio id al server o viceversa? Cosa mettere come parametro?
        //
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
