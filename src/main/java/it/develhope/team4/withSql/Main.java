package it.develhope.team4.withSql;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /*
         * Variabili per accedere al database
         */
        String dburl = "jdbc:mysql://localhost:3306/socialnetwork";
        String userdb = "developer";
        String passworddb = "DeVe1234@#";

        /*
         * Ho creato una connessione
         */
        Connection connection;

        /*
         * Ho creato un result set
         */
        ResultSet rs;

        /*
         * Ho creato un utente di base User
         */
        User user = new User();

        Post post = new Post();

        /*
         * Ho creato uno scanner
         */
        Scanner scanner = new Scanner(System.in);

        try{
            connection = DriverManager.getConnection(dburl, userdb, passworddb);

            Statement statement = connection.createStatement();

            System.out.println("Welcome to Dh Social!");

            /*
             * Chiedo all'utente cosa voglia fare, se fare il login oppure registrarsi
             */
            System.out.println("Do you want to login or register? Please type 'login' or 'register'?");

            RegistrationLogin rl = RegistrationLogin.valueOf(scanner.nextLine().toUpperCase());

            /*
             * Switch con Register e Login come casi
             */
            switch (rl) {
                case REGISTER -> {

                    /*
                     * Chiedo all'utente di inserire il nome e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();
                    user.setNameUser(name);

                    /*
                     * Chiedo all'utente di inserire il cognome e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your surname: ");
                    String surname = scanner.nextLine();
                    user.setSurnameUser(surname);

                    /*
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
                    user.setEmailUser(email);

                    /*
                     * Chiedo all'utente di inserire la password e la salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();
                    user.setPasswordUser(password);

                    /*
                     * Chiedo all'utente di inserire il nickname e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your nickname: ");
                    String nickname = scanner.nextLine();
                    user.setNicknameUser(nickname);

                    /*
                     * Inserisco i dati nel database attraverso i get della classe user
                     */
                    statement.executeUpdate(String.format("insert into `socialnetwork`.`user` (name_user, surname_user, email_user, password_user, nickname_user)" +
                                    "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\");",
                            user.getNameUser(), user.getSurnameUserUser(), user.getEmailUser(), user.getPasswordUser(), user.getNicknameUser()));

                    /*
                     * attraverso un result set estraggo il nickname dat database ed attraverso un ciclo while do il
                     * benvenuto all'utente chiamandolo con il nickname
                     */
                    rs = statement.executeQuery(String.format("select nickname_user from user where nickname_user = \"%s\";", nickname));
                    while (rs.next()) {
                        String nick = rs.getString("nickname_user");
                        System.out.println("Welcome " + nick + "!");
                    }
                }
                case LOGIN -> {

                    /*
                     * Chiedo all'utende di inserire le sue credenziali, ovvero email e password
                     */
                    System.out.println("Enter credentials for login!");
                    System.out.println("Enter your email: ");
                    String email2 = scanner.nextLine();
                    System.out.println("Enter your passowrd: ");
                    String password2 = scanner.nextLine();

                    rs = statement.executeQuery(String.format("select id_user from user where email_user = \"%s\" and password_user = \"%s\"", email2, password2));
                    int idNumber = 0;
                    while (rs.next()) {
                        idNumber = rs.getInt(1);
                        System.out.println("Id user = " + idNumber);
                    }

                    /*
                     * Controllo che siano presenti nel database e attraverso un ciclo while estraggo di nuovo il
                     * nickname e do il banvenuto all'utente.
                     */
                    rs = statement.executeQuery(String.format("select nickname_user from user where email_user=\"%s\" and password_user = \"%s\";", email2, password2));
                    while (rs.next()) {
                        String nick = rs.getString("nickname_user");
                        System.out.println("Welcome back " + nick + "!");
                    }

                    /*
                     * Aggiunta di loop while per rifare domanda all'utente e non far finire l'applicazione
                     */
                    while(true) {
                        System.out.println("What do you want to do? Type 'settings', 'profile', 'chat' or 'community'!" );
                        HomePage hp = HomePage.valueOf(scanner.nextLine().toUpperCase());

                        /*
                         * Costrutto switch per i casi in cui l'utente voglia accedere a setting, profile, chat oppure
                         * community.
                         */
                        switch (hp) {
                            case SETTINGS -> {
                                System.out.println("What do you need to change? Type 'name', 'surname', 'email', 'password' or 'nickname'!" );
                                Settings set = Settings.valueOf(scanner.nextLine().toUpperCase());

                                /*
                                 * All'interno di setting un altro costutto switch per far scegliere all'utente cosa
                                 * voglia modificare tra nome, cognome, email, password e nickname.
                                 * Tutto rigorosametne aggiornato in database
                                 */
                                switch (set) {
                                    case NAME -> {
                                        System.out.println("Enter your new name: " );
                                        String newName = scanner.nextLine();
                                        statement.executeUpdate(String.format("update socialnetwork.user set name_user = \"%s\" where id_user = \"%d\";", newName, idNumber));
                                        rs = statement.executeQuery(String.format("select name_user from user where id_user = \"%d\"", idNumber));
                                        while (rs.next()) {
                                            String name = rs.getString("name_user" );
                                            System.out.println("Your name was changed successfully in " + name);
                                        }

                                    }
                                    case SURNAME -> {
                                        System.out.println("Enter your new surname: " );
                                        String newSurname = scanner.nextLine();
                                        statement.executeUpdate(String.format("update socialnetwork.user set surname_user = \"%s\" where id_user = \"%d\";", newSurname, idNumber));
                                        rs = statement.executeQuery(String.format("select surname_user from user where id_user = \"%d\"", idNumber));
                                        while (rs.next()) {
                                            String surname = rs.getString("surname_user" );
                                            System.out.println("Your name was changed successfully in " + surname);
                                        }
                                    }
                                    case EMAIL -> {
                                        System.out.println("Enter your current email: " );
                                        String email = scanner.nextLine();
                                        System.out.println("Enter your password: " );
                                        String password = scanner.nextLine();
                                        System.out.println("Enter your new email: " );
                                        String newEmail = scanner.nextLine();
                                        statement.executeUpdate(String.format("update socialnetwork.user set email_user = \"%s\" where email_user = \"%s\" and password_user = \"%s\" and id_user = \"%d\";", newEmail, email, password, idNumber));
                                        rs = statement.executeQuery(String.format("select email_user from user where id_user = \"%d\"", idNumber));
                                        while (rs.next()) {
                                            String emailD = rs.getString("email_user" );
                                            System.out.println("Your name was changed successfully in " + emailD);
                                        }
                                    }
                                    case PASSWORD -> {
                                        System.out.println("Enter your email: " );
                                        String email = scanner.nextLine();
                                        System.out.println("Enter your current password: " );
                                        String password = scanner.nextLine();
                                        System.out.println("Enter your new password: " );
                                        String newPassword = scanner.nextLine();
                                        statement.executeUpdate(String.format("update socialnetwork.user set password_user = \"%s\" where email_user = \"%s\" and password_user = \"%s\" and id_user = \"%d\";", newPassword, email, password, idNumber));
                                    }
                                    case NICKNAME -> {
                                        System.out.println("Enter your new nickname: " );
                                        String newNickname = scanner.nextLine();
                                        statement.executeUpdate(String.format("update socialnetwork.user set nickname_user = \"%s\" where id_user = \"%d\";", newNickname, idNumber));
                                        rs = statement.executeQuery(String.format("select nickname_user from user where id_user = \"%d\"", idNumber));
                                        while (rs.next()) {
                                            String nick = rs.getString("nickname_user" );
                                            System.out.println("Your name was changed successfully in " + nick);
                                        }
                                    }
                                }
                            }

                            /*
                             * Caso profilo, in cui per ora l'utente puo sono creare e vedere post
                             */
                            case PROFILE -> {
                                System.out.println("Do you want to create a post o view a post? Type 'create_post' or 'view_post'!" );
                                Profile p = Profile.valueOf(scanner.nextLine().toUpperCase());

                                /*
                                 * Nuovo switch per i casi di creatione e visualizzazione post sempre aggiunti ed
                                 * aggiornati nel database.
                                 */
                                switch (p) {
                                    case CREATE_POST -> {
                                        System.out.println("How do you feel today?" );
                                        String message = scanner.nextLine();
                                        post.setMessagePost(message);

                                        statement.executeUpdate(String.format("insert into `socialnetwork`.`post` (id_user, message_post)" +
                                                        "values (\"%d\", \"%s\");",
                                                idNumber, post.getMessagePost()));
                                    }
                                    case VIEW_POST -> {
                                        rs = statement.executeQuery(String.format("select message_post from socialnetwork.post where id_user = \"%d\";", idNumber));
                                        System.out.println("Your posts\n");
                                        while (rs.next()) {
                                            String message = rs.getString("message_post" );
                                            System.out.println(message);
                                        }
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
