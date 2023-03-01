package it.develhope.team4;

public class Comment {

    private String commentId;
    private String postId;
    private String userId;
    private String comment;


    public Comment(String commentId, String postId, String userId,String comment){
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
    }

    /**
     *  Getters
     */

    public String getCommentId() {
        return commentId;
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

    /**
     *  Setters
     */

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
