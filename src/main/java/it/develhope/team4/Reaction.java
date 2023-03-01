package it.develhope.team4;


public class Reaction {

    private String postId;
    private String userId;
    private Reactions reactionType;

    public Reaction(String postId, String userId, Reactions reactionType ){
        this.postId = postId;
        this.userId = userId;
        this.reactionType = reactionType;
    }


    /**
     *      Getters
     */


    public String getPostID() {
        return postId;
    }

    public String getUserId(){
        return userId;
    }

    public Reactions getReactionType(){
        return reactionType;
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

    public void setReactionType(Reactions reactionType){
        this.reactionType = reactionType;
    }

}
