package it.develhope.team4.withSql;

public class Post {

    /*
     * Creazione classe post con tre variabili, idPost, idUser e messagePost
     */
    private int idPost;
    private int idUser;
    private String messagePost;

    //Setters

    /**
     * Metodo usato per impostare il messaggio del post
     * @param messagePost messaggio del post
     */
    public void setMessagePost(String messagePost){
        this.messagePost = messagePost;
    }

    //Getters

    /**
     * Metodo usato per visualizzare il messaggio del post
     * @return messaggio del post
     */
    public String getMessagePost(){
        return messagePost;
    }
}