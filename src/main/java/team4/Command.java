package team4;

import team4.entities.Comment;
import team4.entities.Post;
import team4.entities.Reaction;
import team4.entities.User;
import team4.enums.ReactionType;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import static team4.Main.*;

public class Command {

    static Scanner s = new Scanner(System.in);

    private String description;

    public Command(String description){
        this.description = description;
    }

    //Come dare una via di uscita dal login o dalla registrazione all'utente?

    public User register(){
        //come dò una via di uscita all'utente?
        System.out.println("Benvenuto nella registrazione!");

        System.out.println("Inserisci il tuo nome");
        String name = s.nextLine();
        System.out.println("Inserisci il tuo cognome");
        String surname = s.nextLine();

        boolean userBool = false;
        String username = null;
        while (!userBool) {
            System.out.println("Inserisci il tuo username");
            username = s.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (!username.equals(users.get(i).getUsername())) {
                    userBool = true;
                }
            }
        }
        System.out.println("Inserisci la tua password");
        String password = s.nextLine();

        users.add(new User(name, surname, username, password));

        System.out.println("Registrazione avvenuta con successo!");

        return new User(name, surname, username, password);

    }

    public Optional<User> searchUser() {
        //come dò una via di uscita all'utente?
        while (true) {
            System.out.println("Inserisci l'username:");
            String u = s.nextLine();
            Optional<User> userIWant = users.stream().filter(elem -> {
                return elem.getUsername().equals(u);
            }).findFirst();
            if(userIWant.isPresent()){
                return userIWant;
            }else{
                System.out.println("User non trovato, riprova!");
            }
        }
    }

    public User login(){
        //come dò una via di uscita all'utente?
        System.out.println("Benvenuto nel login!");

        Optional<User> myUser = this.searchUser();
        System.out.println("Username trovato!");

        boolean doWhile1 = false;

        while(!doWhile1){
            System.out.println("Inserisci la tua password");
            String password = s.nextLine();

            if(password.equals(myUser.get().getPassword())){
                System.out.println("Benvenuto " + myUser.get().getName() + " " + myUser.get().getSurname() +"!");
                doWhile1 = true;
            }else{
                System.out.println("Password errata, riprova!");
            }

        }

        return myUser.get();

    }

    public Post createPost(User user){
        //come dò una via di uscita all'utente?
        System.out.println("Inserisci il messaggio che vuoi postare!");
        String message = s.nextLine();

        Post myPost = new Post(user, message, LocalDateTime.now());
        user.userPosts.add(myPost);

        System.out.println("Post creato con successo!");
        return myPost;
    }

    public Post choosePost(User user){
        //come dò una via di uscita all'utente?
        while(true){
            System.out.println("Scegli il post (inserendo il numero corrispondente):");
            int postNum = s.nextInt();
            s.next();
            if(postNum < user.userPosts.size()){
                return user.userPosts.get(postNum);
            }else{
                System.out.println("Post non esistente, riprova!");
            }
        }
    }

    public Comment comment(User user){
        //come dò una via di uscita all'utente?
        Post thisPost;

        Optional <User> myUser = this.searchUser();
        System.out.println("User trovato, ecco i suoi post:");
        System.out.println(myUser.get().userPosts);

        thisPost = this.choosePost(myUser.get());
        System.out.println("Post trovato!");

        System.out.println("Inserisci il commento che vuoi postare!");
        String message = s.nextLine();

        Comment myComment = new Comment(thisPost, user, message);
        thisPost.comments.add(myComment);

        return myComment;

    }

    public Reaction react(User user) {
        Post thisPost;
        Optional<User> myUser = this.searchUser();

        System.out.println("User trovato, ecco i suoi post:");
        System.out.println(myUser.get().userPosts);

        thisPost = this.choosePost(myUser.get());
        System.out.println("Post trovato!");

        boolean a = false;
        ReactionType reactionType = null;

        //come dò una via di uscita all'utente?
        while (!a) {
            System.out.println("Scegli la reaction che vuoi postare! (inserisci il numero corrispondente)");
            int i = 0;
            for (ReactionType r : ReactionType.values()) {
                i++;
                System.out.println(r);
            }
            int numChosen = s.nextInt();
            s.next();

            if (numChosen < i) {
                int j = 0;
                for (ReactionType r : ReactionType.values()) {
                    j++;
                    if (numChosen == j) {
                        reactionType = r;
                    }
                }
                a = true;
            } else {
                System.out.println("Reaction non esistente, riprova!");
            }
        }

        Reaction myReaction = new Reaction(thisPost, user, reactionType);
        thisPost.reactions.add(myReaction);

        return myReaction;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
