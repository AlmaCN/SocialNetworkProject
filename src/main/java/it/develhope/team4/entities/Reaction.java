package it.develhope.team4.entities;

import it.develhope.team4.enums.Reactions;

public class Reaction {

    private String postId;
    private String userId;
    private Reactions reactionType;

    public Reaction(String postId, String userId, Reactions reactionType){
        this.postId = postId;
        this.userId = userId;
        this.reactionType = reactionType;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public Reactions getReactionType() {
        return reactionType;
    }
}
