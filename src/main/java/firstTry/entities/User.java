package firstTry.entities;

import firstTry.exceptions.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class User{

    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int age;
    private String gender;
    private String email;
    private String username;
    private String telephone;
    private String password;
    /**
     * Lista dei post dell'utente
     */
    //l'utente conosce l'essistenza dei post e questa è la lista di tutti i suoi post
    public List<Post> posts = new ArrayList<>();

    /**
     * AllArgsConstructor tranne age calcolata in automatico dalla data di nascita
     * @param name Nome dell'utente
     * @param surname Cognome dell'utente
     * @param formattedDateOfBirth Data di nascita dell'utente
     * @param telephone Numero di telefono dell'utente
     * @param gender Gender of the user
     * @param email Email of the user
     * @param username Username the user will choose
     * @param password Password the user will choose
     */
    public User(String id, String name, String surname, String formattedDateOfBirth, String telephone, String gender, String email, String username, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        //trasformo la stringa della data in una LocalDate
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        this.birthDate = LocalDate.parse(formattedDateOfBirth, f);
        //calcolo l'età dalla data di nascita
        this.age = Period.between(birthDate, currentDate).getYears();
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.telephone = telephone;
        this.password = password;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static User register() {

        System.out.println("Iniziamo la registrazione!");

        String uniqueID = UUID.randomUUID().toString();

        boolean validName = false;
        String newName = null;
        while (!validName) {
            try {
                newName = User.registerName();
                validName = true;
            } catch (NameSurnameException e) {
                e.getMessage();
            }
        }

        boolean validSurname = false;
        String newSurname = null;
        while (!validSurname) {
            try {
                newSurname = User.registerSurname();
                validSurname = true;
            } catch (NameSurnameException e) {
                e.getMessage();
            }
        }

        boolean validDate = false;
        String newDateOfBirth = null;
        while (!validDate) {
            try {
                newDateOfBirth = User.registerDate();
                validDate = true;
            } catch (DateException e) {
                e.getMessage();
            }
        }

        boolean validTelephone = false;
        String newTelephone = null;
        while (!validTelephone) {
            AtomicBoolean doubleTelephone = new AtomicBoolean(false);
            try {
                newTelephone = User.registerTelephone();
                String finalNewTelephone = newTelephone;
                Database.users.forEach((id, singleUser)->{
                    if(singleUser.telephone.equals(finalNewTelephone)){
                        System.out.println("Telefono già registrato, riprova o vai al login");
                        doubleTelephone.set(true);
                    }
                });
                if(!doubleTelephone.get()){
                    validTelephone = true;
                }
            } catch (TelephoneException e) {
                e.getMessage();
            }
        }

        boolean validGender = false;
        String newGender = null;
        while (!validGender) {
            try {
                newGender = User.registerGender();
                validGender = true;
            } catch (GenderException e) {
                e.getMessage();
            }
        }

        boolean validEmail = false;
        String newEmail = null;
        while (!validEmail) {
            AtomicBoolean doubleEmail = new AtomicBoolean(false);
            try {
                newEmail = User.registerEmail();
                String finalNewEmail = newEmail;
                Database.users.forEach((id, singleUser)->{
                    if(singleUser.email.equals(finalNewEmail)){
                        System.out.println("Email già registrata, riprova o vai al login");
                        doubleEmail.set(true);
                    }
                });
                if(!doubleEmail.get()){
                    validEmail = true;
                }
            } catch (EmailException e) {
                e.getMessage();
            }
        }

        boolean validUsername = false;
        String newUsername = null;
        while (!validUsername) {
            AtomicBoolean doubleUsername = new AtomicBoolean(false);
            try {
                newUsername = User.registerUsername();
                String finalNewUsername = newUsername;
                Database.users.forEach((id, singleUser)->{
                    if(singleUser.username.equals(finalNewUsername)){
                        System.out.println("Username già registrato, riprova o vai al login");
                        doubleUsername.set(true);
                    }
                });
                if(!doubleUsername.get()){
                    validUsername = true;
                }
            } catch (UsernameException e) {
                e.getMessage();
            }
        }

        boolean validPassword = false;
        String newPassword = null;
        while (!validPassword) {
            try {
                newPassword = User.registerPassword();
                validPassword = true;
            } catch (PasswordException e) {
                e.getMessage();
            }
        }

        User newUser = new User(uniqueID, newName, newSurname, newDateOfBirth, newTelephone, newGender, newEmail, newUsername, newPassword);

        Database.users.put(newUsername, newUser);

        System.out.println("Registrazione eseguita con successo, grazie " + Database.users.get(newUsername).name + "!");

        return newUser;

    }

    private static String registerName() throws NameSurnameException{

        System.out.println("Inserisci il tuo nome: ");
        String newName = scanner.nextLine().replaceAll("/s", "");
        if(newName.length() > 10){
            throw new NameSurnameException();
        }else{
            return newName;
        }
    }

    private static String registerSurname() throws NameSurnameException{

        System.out.println("Inserisci il tuo cognome: ");
        String newSurname = scanner.nextLine().replaceAll("/s", "");
        if(newSurname.length() > 10){
            throw new NameSurnameException();
        }else{
            return newSurname;
        }
    }

    private static String registerDate() throws DateException{

        System.out.println("Inserisci la tua data di nascita: (in formato dd/MM/yyyy)");
        String newDateOfBirth = scanner.nextLine().replaceAll("/s", "");
        if(!newDateOfBirth.contains("/")){
            throw new DateException();
        }else{
            return newDateOfBirth;
        }
    }

    private static String registerTelephone() throws TelephoneException{

        System.out.println("Inserisci il tuo numero di telefono: ");
        String newTelephone= scanner.nextLine().replaceAll("/s", "");
        if(!newTelephone.contains("3")){
            throw new TelephoneException();
        }else{
            return newTelephone;
        }
    }

    private static String registerGender() throws GenderException{

        System.out.println("Inserisci il tuo genere per intero: ");
        String newGender= scanner.nextLine().trim().toLowerCase();
        switch(newGender){
            case "femmina" : case "maschio" : case "non binario" : case "altro" :
                return newGender;
            default:
                throw new GenderException();
        }
    }

    private static String registerEmail() throws EmailException{

        System.out.println("Inserisci la tua email: ");
        String newEmail= scanner.nextLine().replaceAll("/s", "");
        if(!newEmail.contains("@") || !newEmail.contains(".")){
            throw new EmailException();
        }else{
            return newEmail;
        }
    }

    private static String registerUsername() throws UsernameException{

        System.out.println("Inserisci il tuo username: ");
        String newUsername= scanner.nextLine().replaceAll("/s", "");
        if(newUsername.length() > 10){
            throw new UsernameException();
        }else{
            return newUsername;
        }
    }

    private static String registerPassword() throws PasswordException{

        System.out.println("Inserisci la tua password: ");
        String newPassword= scanner.nextLine().replaceAll("/s", "");
        if(newPassword.length() > 10 || newPassword.length() < 6){
            throw new PasswordException();
        }else{
            return newPassword;
        }
    }

    public static void login(){

        System.out.println("Iniziamo il login!");

        boolean stopWhile = false;
        while(!stopWhile){
            System.out.println("Se non ricordi l'username scrivi email o tel a seconda di cosa vuoi usare per accedere!");
            System.out.println("Inserisci il tuo username: ");
            String myUsername= scanner.nextLine().replaceAll("/s", "");
            if(myUsername.equalsIgnoreCase("tel")){
                //da implementare
            }else if(myUsername.equalsIgnoreCase("email")){
                //da implementare
            }else{
                User myUser = Database.users.get(myUsername);
                try{
                    if(!myUser.equals(null)) {
                        System.out.println("Inserisci la tua password: ");
                        String myPassword = scanner.nextLine().replaceAll("/s", "");
                        if (myUser.password.equals(myPassword)) {
                            System.out.println("Login avvenuto con successo! Welcome " + Database.users.get(myUsername).name + "!");
                            stopWhile = true;
                        } else {
                            System.out.println("Password errata, riprova!");
                        }
                    }
                }catch(NullPointerException e){
                    System.out.println("Noi sei loggato con questo Username! Riprova!");
                }
            }
        }
    }

}
