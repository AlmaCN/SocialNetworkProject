package it.develhope.team4.withSql;

public class Post {

    private int idPost;
    private int idUser;
    private String messagePost;

    //Setters
    public void setMessagePost(String messagePost){
        this.messagePost = messagePost;
    }

    //Getters
    public String getMessagePost(){
        return messagePost;
    }
}