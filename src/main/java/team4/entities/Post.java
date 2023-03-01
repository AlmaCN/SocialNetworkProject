package team4.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private String message;
    private User user;
    private LocalDateTime publicationDate;
    //ancora da capire come usarlo!
    //private PrivacyType privacy;
    public List<Reaction> reactions = new ArrayList<>();
    public List <Comment> comments = new ArrayList<>();

    public Post(User user, String message, LocalDateTime date) {
        this.user = user;
        this.message = message;
        this.publicationDate = date;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalDateTime getPublicationDate(){
        return this.publicationDate;
    }

    public User getUser(){
        return this.user;
    }

    @Override
    public String toString() {
        return message + "-----" + publicationDate.toString();
    }
}
