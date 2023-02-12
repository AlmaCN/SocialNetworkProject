package it.develhope.team4;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post{
    private String postId;
    private String userId;
    private String postDescription;
    LocalDateTime publicationDate;
    LocalDateTime lastUpdateDate;
    private PrivacyType privacy;

    List <Reactions> reactions = new ArrayList<>();
    List <Comment> comments = new ArrayList<>();

    public Post(){

    }



}
