package it.develhope.team4.withSql;

import it.develhope.team4.withSql.database.Database;
import it.develhope.team4.withSql.entities.Post;
import it.develhope.team4.withSql.entities.User;
import it.develhope.team4.withSql.enumerations.HomePage;
import it.develhope.team4.withSql.enumerations.Profile;
import it.develhope.team4.withSql.enumerations.RegistrationLogin;
import it.develhope.team4.withSql.enumerations.Settings;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /**
         * Ho creato uno scanner
         */
        Scanner scanner = new Scanner(System.in);

        try{

            /**
             * Ho creato un oggetto User ed uno Post per poter richiamare i vari metodi
             */
            User user = new User();
            Post post = new Post();
            /**
             * Ho aggiunto un oggetto di tipo Database
             * Nel caso in cui si voglia provare il codice, creare uno schema nel proprio database chiamato
             * socialnetwork e cambiare userdb e passworddb nella classe Database
             */
            Database db = new Database();
            user.createTableUser();
            post.createTablePost();

            /**
             * Aggiunta di ciclo while per tenere 'vivo' il codice nel momento il cui l'utente inserisce exit nel
             * successivo ciclo while
             *
             */
            while(true) {
                System.out.println("Welcome to Dh Social!");

                /**
                 * Chiedo all'utente cosa voglia fare, se fare il login oppure registrarsi
                 */
                System.out.println("Do you want to login or register? Please type 'login' or 'register'?");

                RegistrationLogin rl = RegistrationLogin.valueOf(scanner.nextLine().toUpperCase());

                /**
                 * Switch con Register e Login come casi
                 */
                switch (rl) {
                    case REGISTER -> {
                        user.userRegister();
                    }
                    case LOGIN -> {
                        user.userLogin();

                        /**
                         * Aggiunta di loop while per rifare domanda all'utente e non far finire l'applicazione, nel
                         * caso in cui inserisca 'exit' e presente un altro ciclo while che chiede all'utente se
                         * desidera eseguire il login oppure registrarsi
                         */

                        HomePage hp = null;
                        while (hp != hp.EXIT) {
                            System.out.println("What do you want to do? Type 'settings', 'profile', 'chat', 'community' or 'exit'!");
                            hp = HomePage.valueOf(scanner.nextLine().toUpperCase());

                            /**
                             * Costrutto switch per i casi in cui l'utente voglia accedere a setting, profile, chat oppure
                             * community.
                             */
                            switch (hp) {
                                case SETTINGS -> {
                                    System.out.println("What do you need to change? Type 'name', 'surname', 'email', 'password' or 'nickname'!");
                                    Settings set = Settings.valueOf(scanner.nextLine().toUpperCase());

                                    /**
                                     * All'interno di setting un altro costrutto switch per far scegliere all'utente cosa
                                     * voglia modificare tra nome, cognome, email, password e nickname.
                                     * Tutto rigorosametne aggiornato in database
                                     */
                                    switch (set) {
                                        case NAME -> {
                                            user.changeName();
                                        }
                                        case SURNAME -> {
                                            user.changeSurname();
                                        }
                                        case EMAIL -> {
                                            user.changeEmail();
                                        }
                                        case PASSWORD -> {
                                            user.changePassword();
                                        }
                                        case NICKNAME -> {
                                            user.changeNickname();
                                        }
                                    }
                                }

                                /**
                                 * Caso profilo, in cui per ora l'utente puo sono creare e vedere post
                                 */
                                case PROFILE -> {
                                    System.out.println("Do you want to create a post o view a post? Type 'create_post' or 'view_post'!");
                                    Profile p = Profile.valueOf(scanner.nextLine().toUpperCase());

                                    /**
                                     * Nuovo switch per i casi di creatione e visualizzazione post sempre aggiunti ed
                                     * aggiornati nel database.
                                     */
                                    switch (p) {
                                        case CREATE_POST -> {
                                            post.createPost();
                                        }
                                        case VIEW_POST -> {
                                            post.viewPost();
                                            System.out.println();
                                        }
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
