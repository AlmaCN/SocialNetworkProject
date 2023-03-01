package team4.entities;

import team4.enums.ReactionType;

public class Reaction {
    private Post post;
    private User user;
    private ReactionType reactionType;

    public Reaction(Post post, User user, ReactionType reactionType){
        this.post = post;
        this.user = user;
        this.reactionType = reactionType;
    }

    public Post getPost(){
        return this.post;
    }

    public User getUser(){
        return this.user;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

}
