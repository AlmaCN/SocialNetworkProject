package it.develhope.team4;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Post {

    public UserDeprecato username;
    public UUID postId;
    public LocalDateTime creationDate;
    public LocalDateTime updateDate;
    public String message;
    public ReactionType reaction;
    //List<Post> posts;
    HashMap<UserDeprecato, UUID> posts = new HashMap<>();

//    public Post(User username, String message){
//        this.username = username;
//        this.message = message;
//    }

    public Post(){};

    public void postCreation(UserDeprecato username, String message){
        this.username = username;
        LocalDateTime ldt = LocalDateTime.now();
        creationDate = ldt;
        System.out.println(creationDate);
        postId = UUID.randomUUID();
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        this.message = sc.nextLine();

        posts.put(username, postId);
    }

    public void postModify(){
        LocalDateTime ldt = LocalDateTime.now();
        updateDate = ldt;
        System.out.println(updateDate);
    }

    public void postReaction(ReactionType reaction){
        switch (reaction) {
            case LIKE -> System.out.println("You liked " + username.username + "'s post");
            case LAUGH -> System.out.println("You laughed at " + username.username + "'s post");
            case HEART -> System.out.println("You put a heart on " + username.username + "'s post");
            case ANGRY -> System.out.println("You got angry on " + username.username + "'s post");
            case SURPRISED -> System.out.println("You got surprised by " + username.username + "'s post");
            case SAD -> System.out.println("You got sad from " + username.username + "'s post");
        }
    }

}
