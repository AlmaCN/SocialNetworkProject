package team4.entities;

import java.time.LocalDateTime;

public class Comment {

    private Post post;
    private User user;
    private String comment;
    private LocalDateTime publicationDate;

    public Comment(Post post, User user, String comment){
        this.post = post;
        this.user = user;
        this.comment = comment;
        this.publicationDate = LocalDateTime.now();
    }

    public Post getPost() {
        return this.post;
    }

    public User getUser() {
        return this.user;
    }

    public LocalDateTime getPublicationDate(){
        return this.publicationDate;
    }

    public String getComment() {
        return comment;
    }

}
