package it.develhope.team4.entities;

import it.develhope.team4.enums.PrivacyType;
import it.develhope.team4.enums.Reactions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post {

    private String postId;
    private String userId;
    private String urlImg;
    private String postDescription;
    private LocalDateTime publicationDate;
    private LocalDateTime lastUpdateDate;
    private PrivacyType privacy;
    private List<Reaction> reactions = new ArrayList<>();
    private List <Comment> comments = new ArrayList<>();

    public Post(String userId, String urlImg, String postDescription, PrivacyType privacy){
        this.postId = UUID.randomUUID().toString();
        this.userId = userId;
        this.urlImg = urlImg;
        this.postDescription = postDescription;
        this.privacy = privacy;
        this.publicationDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    public void addComment(String idUser, String comment){
        comments.add(new Comment(this.postId, idUser, comment));
    }

    public void deleteComment(){

    }

    public void addReaction(String idUser, Reactions reaction){
        reactions.add(new Reaction(this.postId, idUser,reaction));
    }

    public void deleteReaction(){

    }

    public void sharePost(){
        //In questa classe? Che parametri in input? E output? Implementazione?
    }

    public void modifyPost(){
        //da dividere? Come? In questa classe? Che parametri in input? E output?
    }

    public void deletePost(){

    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public PrivacyType getPrivacy() {
        return privacy;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

}
