package it.develhope.team4.withSql.entities;

import it.develhope.team4.withSql.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private int idUser;
    private String nameUser;
    private String surnameUser;
    private String emailUser;
    private String passwordUser;
    private String nicknameUser;

    Database db = new Database();
    Connection connection = DriverManager.getConnection(db.getDbUrl(), db.getUserDb(), db.getPasswordDb());
    ResultSet rs;
    Scanner scanner = new Scanner(System.in);

    public User() throws SQLException {
    }

    //Setters per name, surname, email, password e nickname.
    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }

    public void setSurnameUser(String surnameUser){
        this.surnameUser = surnameUser;
    }

    public void setEmailUser(String emailUser){
        this.emailUser = emailUser;
    }


    public void setPasswordUser(String passwordUser){
        this.passwordUser = passwordUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    //Getters per name, surname, email, password e nickname.
    public String getNameUser(){
        return nameUser;
    }

    public String getSurnameUserUser(){
        return surnameUser;
    }

    public String getEmailUser(){
        return emailUser;
    }

    public String getPasswordUser(){
        return passwordUser;
    }

    public String getNicknameUser(){
        return nicknameUser;
    }

    /**
     * Metodo per creare se non esiste la tabella user nel database indicato.
     * @throws SQLException
     */
    public void createTableUser() throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS `socialnetwork`.`user` " +
                "(`id_user` INT NOT NULL AUTO_INCREMENT," +
                "`name_user` VARCHAR(45) NULL," +
                "`surname_user` VARCHAR(45) NULL," +
                "`email_user` VARCHAR(45) NULL," +
                "`password_user` VARCHAR(45) NULL," +
                "`nickname_user` VARCHAR(45) NULL, " +
                "PRIMARY KEY (`id_user`), " +
                "UNIQUE INDEX `email_user_UNIQUE` (`email_user` ASC) VISIBLE, " +
                "UNIQUE INDEX `password_user_UNIQUE` (`password_user` ASC) VISIBLE, " +
                "UNIQUE INDEX `nickname_user_UNIQUE` (`nickname_user` ASC) VISIBLE);");
    }

    /**
     * Metodo per la registrazionel dell'user
     * @throws SQLException
     */
    public void userRegister() throws SQLException {

        /**
         * Chiedo all'utente di inserire il nome e lo salvo temporaneamente nella classe user
         */
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        setNameUser(name);

        /**
         * Chiedo all'utente di inserire il cognome e lo salvo temporaneamente nella classe user
         */
        System.out.println("Enter your surname: ");
        String surname = scanner.nextLine();
        setSurnameUser(surname);

        /**
         * Chiedo all'utente di inserire l'email e verifico che sia veramente un email e la salvo
         * temporaneamente nella classe user
         */
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        boolean bool = false;
        do {
            Pattern p = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
            Matcher m = p.matcher(email);
            boolean b = m.matches();

            if (!b) {
                System.out.println("Email not valid, please enter again: ");
                email = scanner.nextLine();
            } else if(b){
                System.out.println("Email correct");
                break;
            }
        } while (!bool);
        setEmailUser(email);

        /**
         * Chiedo all'utente di inserire la password e la salvo temporaneamente nella classe user
         */
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        setPasswordUser(password);

        /**
         * Chiedo all'utente di inserire il nickname e lo salvo temporaneamente nella classe user
         */
        System.out.println("Enter your nickname: ");
        String nickname = scanner.nextLine();
        setNicknameUser(nickname);

        /**
         * Inserisco i dati nel database attraverso i get della classe user
         */
        connection.createStatement().executeUpdate(String.format("insert into `socialnetwork`.`user` (name_user, surname_user, email_user, password_user, nickname_user)" +
                        "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\");",
                getNameUser(), getSurnameUserUser(), getEmailUser(), getPasswordUser(), getNicknameUser()));

        /**
         * attraverso un result set estraggo il nickname dat database ed attraverso un ciclo while do il
         * benvenuto all'utente chiamandolo con il nickname
         */
        rs = connection.createStatement().executeQuery(String.format("select nickname_user from user where nickname_user = \"%s\";", nickname));
        while (rs.next()) {
            String nick = rs.getString("nickname_user");
            System.out.println("Welcome " + nick + "!");
        }

    }

    /**
     * Metodo per il login dell'user
     * @throws SQLException
     */
    public void userLogin() throws SQLException {
        /*
         * Chiedo all'utende di inserire le sue credenziali, ovvero email e password
         */
        System.out.println("Enter credentials for login!");
        System.out.println("Enter your email: ");
        String email2 = scanner.nextLine();
        System.out.println("Enter your passowrd: ");
        String password2 = scanner.nextLine();

        rs = connection.createStatement().executeQuery(String.format("select id_user from user where email_user = \"%s\" and password_user = \"%s\"", email2, password2));
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
            System.out.println("Id user = " + idUser);
        }

        /*
         * Controllo che siano presenti nel database e attraverso un ciclo while estraggo di nuovo il
         * nickname e do il banvenuto all'utente.
         */
        rs = connection.createStatement().executeQuery(String.format("select nickname_user from user where email_user=\"%s\" and password_user = \"%s\";", email2, password2));
        while (rs.next()) {
            String nick = rs.getString("nickname_user");
            System.out.println("Welcome back " + nick + "!");
        }
    }

    /**
     * Metodo per permettere all'utente di modificare il name
     * @throws SQLException
     */
    public void changeName() throws SQLException {
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("Enter your new name: " );
        String newName = scanner.nextLine();
        connection.createStatement().executeUpdate(String.format("update socialnetwork.user set name_user = \"%s\" where id_user = \"%d\";", newName, idUser));
        rs = connection.createStatement().executeQuery(String.format("select name_user from user where id_user = \"%d\"", idUser));
        while (rs.next()) {
            String name = rs.getString("name_user" );
            System.out.println("Your name was changed successfully in " + name);
        }
    }

    /**
     * Metodo per permettere all'utente di modificare il surname
     * @throws SQLException
     */
    public void changeSurname() throws SQLException {
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("Enter your new surname: " );
        String newSurname = scanner.nextLine();
        connection.createStatement().executeUpdate(String.format("update socialnetwork.user set surname_user = \"%s\" where id_user = \"%d\";", newSurname, idUser));
        rs = connection.createStatement().executeQuery(String.format("select surname_user from user where id_user = \"%d\"", idUser));
        while (rs.next()) {
            String surname = rs.getString("surname_user" );
            System.out.println("Your name was changed successfully in " + surname);
        }
    }

    /**
     * Metodo per permettere all'utente di modificare l'email
     * @throws SQLException
     */
    public void changeEmail() throws SQLException {
        idUser  = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("Enter your current email: " );
        String email = scanner.nextLine();
        System.out.println("Enter your password: " );
        String password = scanner.nextLine();
        System.out.println("Enter your new email: " );
        String newEmail = scanner.nextLine();
        connection.createStatement().executeUpdate(String.format("update socialnetwork.user set email_user = \"%s\" where email_user = \"%s\" and password_user = \"%s\" and id_user = \"%d\";", newEmail, email, password, idUser));
        rs = connection.createStatement().executeQuery(String.format("select email_user from user where id_user = \"%d\"", idUser));
        while (rs.next()) {
            String emailD = rs.getString("email_user" );
            System.out.println("Your name was changed successfully in " + emailD);
        }
    }

    /**
     * Metodo per permettere all'utente di modificare la password
     * @throws SQLException
     */
    public void changePassword() throws SQLException {
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("Enter your email: " );
        String email = scanner.nextLine();
        System.out.println("Enter your current password: " );
        String password = scanner.nextLine();
        System.out.println("Enter your new password: " );
        String newPassword = scanner.nextLine();
        connection.createStatement().executeUpdate(String.format("update socialnetwork.user set password_user = \"%s\" where email_user = \"%s\" and password_user = \"%s\" and id_user = \"%d\";", newPassword, email, password, idUser));
    }

    /**
     * Metodo per permettere all'utente di modificare il nickname
     * @throws SQLException
     */
    public void changeNickname() throws SQLException {
        idUser = 0;
        while (rs.next()) {
            idUser = rs.getInt(1);
        }
        System.out.println("Enter your new nickname: " );
        String newNickname = scanner.nextLine();
        connection.createStatement().executeUpdate(String.format("update socialnetwork.user set nickname_user = \"%s\" where id_user = \"%d\";", newNickname, idUser));
        rs = connection.createStatement().executeQuery(String.format("select nickname_user from user where id_user = \"%d\"", idUser));
        while (rs.next()) {
            String nick = rs.getString("nickname_user" );
            System.out.println("Your name was changed successfully in " + nick);
        }
    }
}
