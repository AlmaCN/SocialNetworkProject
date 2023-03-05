package it.develhope.team4.withSql.entities;

import it.develhope.team4.withSql.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Post {

    /**
     * Creazione classe post con tre variabili, idPost, idUser e messagePost
     */
    private int idPost;
    private int idUser;
    private String messagePost;

    Database db = new Database();
    Connection connection = DriverManager.getConnection(db.getDbUrl(), db.getUserDb(), db.getPasswordDb());
    ResultSet rs;
    Scanner scanner = new Scanner(System.in);

    public Post() throws SQLException {
    }

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

    /**
     * Metodo usato per creare se non esiste la tabella post con tanto di foreign key collegata alla tabella user
     * @throws SQLException
     */
    public void createTablePost() throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS `socialnetwork`.`post` " +
                "(`id_post` INT NOT NULL AUTO_INCREMENT," +
                "`id_user` INT NOT NULL," +
                "`message_post` VARCHAR(1000) NULL," +
                "PRIMARY KEY (`id_post`)," +
                "INDEX `id_user_idx` (`id_user` ASC) VISIBLE," +
                "CONSTRAINT `id_user`" +
                "FOREIGN KEY (`id_user`)" +
                "REFERENCES `socialnetwork`.`user` (`id_user`));");
    }

    /**
     * Metodo per creare post e salvarli nel database
     * @throws SQLException
     */
    public void createPost() throws SQLException {
        System.out.println("What is your nickname?");
        String nickname = scanner.nextLine();
        rs = connection.createStatement().executeQuery(String.format("select id_user from user where nickname_user = \"%s\"", nickname));
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("How do you feel today?" );
        String message = scanner.nextLine();
        setMessagePost(message);

        connection.createStatement().executeUpdate(String.format("insert into `socialnetwork`.`post` (id_user, message_post)" +
                        "values (\"%d\", \"%s\");",
                idUser, getMessagePost()));
    }

    /**
     * Metodo per selezionare e visualizzare i propri post
     * @throws SQLException
     */
    public void viewPost() throws SQLException {
        System.out.println("What is your nickname?");
        String nickname = scanner.nextLine();
        rs = connection.createStatement().executeQuery(String.format("select id_user from user where nickname_user = \"%s\"", nickname));
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        rs = connection.createStatement().executeQuery(String.format("select message_post from socialnetwork.post where id_user = \"%d\";", idUser));
        System.out.println("Your posts\n");
        while (rs.next()) {
            String message = rs.getString("message_post" );
            System.out.println(message);
        }
    }
}