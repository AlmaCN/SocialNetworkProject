package it.develhope.team4.entities;

public class Comment {

    private String postId;
    private String userId;
    private String comment;

    public Comment(String postId, String userId, String comment){
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }
}
