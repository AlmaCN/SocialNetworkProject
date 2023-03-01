package firstTry.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post {

    String idPost;
    public String username;
    public String message;
    private User user;
    public LocalDateTime publicationDate;
    public LocalDateTime lastUpdateDate;
    public List <Reaction> reactions = new ArrayList<>();

    public Post(User user, String message){
        this.idPost = UUID.randomUUID().toString();
        this.user = user;
        this.publicationDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
        this.message = message;
    }

    public static void createPost(User user){
        Post newPost = new Post(user, "Ciao oggi sono felice e voi?");
        System.out.println(newPost);
        Database.allPosts.add(newPost);
    }

    public void modifyPost(){
        //modifichi lastUpdateDate
    }

    @Override
    public String toString() {
        return "Post { " +"\n" +
                username + "                     " + lastUpdateDate + "\n"
                + message + "\n" +
                reactions + "\n" +
                " }";
    }
}
