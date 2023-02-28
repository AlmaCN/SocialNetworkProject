package it.develhope.team4.withSql;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /**
         * Variabili per accedere al database
         */
        String dburl = "jdbc:mysql://localhost:3306/socialnetwork";
        String userdb = "developer";
        String passworddb = "DeVe1234@#";

        /**
         * Ho creato una connessione
         */
        Connection connection;

        /**
         * Ho creato un result set
         */
        ResultSet rs;

        /**
         * Ho creato un utente di base User
         */
        User user = new User();

        /**
         * Ho creato uno scanner
         */
        Scanner scanner = new Scanner(System.in);

        try{
            connection = DriverManager.getConnection(dburl, userdb, passworddb);

            Statement statement = connection.createStatement();

            System.out.println("Welcome to Dh Social!");

            /**
             * Chiedo all'utente cosa voglia fare, se fare il login oppure registrarsi
             */
            System.out.println("Login or Register?");

            RegistrationLogin rl = RegistrationLogin.valueOf(scanner.nextLine().toUpperCase());

            /**
             * Switch con Register e Login come casi
             */
            switch (rl) {
                case REGISTER -> {

                    /**
                     * Chiedo all'utente di inserire il nome e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();
                    user.setNameUser(name);

                    /**
                     * Chiedo all'utente di inserire il cognome e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your surname: ");
                    String surname = scanner.nextLine();
                    user.setSurnameUser(surname);

                    /**
                     * Chiedo all'utente di inserire l'email e verifico che sia veramente un email e la salvo
                     * temporaneamente nella classe user
                     */
                    System.out.println("Enter your email: ");
                    String email = scanner.nextLine();
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
                        }
                    } while (false);
                    user.setEmailUser(email);

                    /**
                     * Chiedo all'utente di inserire la password e la salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();
                    user.setPasswordUser(password);

                    /**
                     * Chiedo all'utente di inserire il nickname e lo salvo temporaneamente nella classe user
                     */
                    System.out.println("Enter your nickname: ");
                    String nickname = scanner.nextLine();
                    user.setNicknameUser(nickname);

                    /**
                     * Inserisco i dati nel database attraverso i get della classe user
                     */
                    statement.executeUpdate(String.format("insert into `socialnetwork`.`user` (name_user, surname_user, email_user, password_user, nickname_user)" +
                                    "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\");",
                            user.getNameUser(), user.getSurnameUserUser(), user.getEmailUser(), user.getPasswordUser(), user.getNicknameUser()));

                    /**
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

                    /**
                     * Chiedo all'utende di inserire le sue credenziali, ovvero email e password
                     */
                    System.out.println("Enter credentials for login!");
                    System.out.println("Enter your email: ");
                    String email2 = scanner.nextLine();
                    System.out.println("Enter your passowrd: ");
                    String password2 = scanner.nextLine();

                    /**
                     * Controllo che siano presenti nel database e attraverso un ciclo while estraggo di nuovo il
                     * nickname e do il banvenuto all'utente.
                     */
                    rs = statement.executeQuery(String.format("select nickname_user from user where email_user=\"%s\" and password_user = \"%s\";", email2, password2));
                    while (rs.next()) {
                        String nick = rs.getString("nickname_user");
                        System.out.println("Welcome back " + nick + "!");
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
