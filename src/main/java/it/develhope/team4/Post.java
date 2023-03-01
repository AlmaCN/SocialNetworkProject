package it.develhope.team4;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post{

    private String postId;
    private String userId;
    private String postDescription;
    private PrivacyType privacy;

    private LocalDateTime publicationDate;
    private LocalDateTime lastUpdateDate;

    List <Reactions> reactions = new ArrayList<>();
    List <Comment> comments = new ArrayList<>();

    public Post(String postId, String userId, String postDescription, PrivacyType privacy,
                LocalDateTime publicationDate, LocalDateTime lastUpdateDate){

        this.postId = postId;
        this.userId = userId;
        this.postDescription = postDescription;
        this.privacy = privacy;
        this.publicationDate = publicationDate;
        this.lastUpdateDate = lastUpdateDate;
    }


    /**
     *      Getters
     */


    public String getPostId (){
        return postId;
    }

    public String getUserId(){
        return userId;
    }

    public String getPostDescription(){
        return postDescription;
    }

    public PrivacyType privacy(){
        return privacy;
    }

    public LocalDateTime getPublicationDate(){
        return publicationDate;
    }

    public LocalDateTime getLastUpdateDate(){
        return lastUpdateDate;
    }


    /**
     *      Setters
     */


    public void setPostId(String postId){
        this.postId = postId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setPostDescription(String postDescription){
        this.postDescription = postDescription;
    }

    public void setPrivacyType(PrivacyType privacy){
        this.privacy = privacy;
    }

    public void setPublicationDate(LocalDateTime publicationDate){
        this.publicationDate = publicationDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate){
        this.publicationDate = lastUpdateDate;
    }


}
