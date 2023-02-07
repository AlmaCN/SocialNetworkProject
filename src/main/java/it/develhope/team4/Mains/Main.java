package it.develhope.team4.Mains;


import it.develhope.team4.Entities.HomePage;
import it.develhope.team4.Entities.User;
import it.develhope.team4.Functions.CreateUser;
import it.develhope.team4.Interfaces.PrivacyType;

public class Main {
    public static void main(String[] args) throws InterruptedException {


/** uncommentare solo 1 sezione x testare */



/** test creazione 2 utenti tramite scanner */
//        CreateUser cr = new CreateUser();
//        User userN2 = cr.userRegistration();
//        User userN1 = cr.userRegistration();
//


 /** test creazione user creato in compiler */
        CreateUser cr2 = new CreateUser();
        User user1 = cr2.userRegistration2("ale","gob","ale@gmail");
        User user2 = cr2.userRegistration2("mario","rossi","mario@gmail");
        cr2.stampaLista();


/** test messaggi home */
//        User aleG = new User("alessandro","gob","ale@gmail","12aas3",false,1);
//        HomePage posts = new HomePage();
//        posts.postMessage(aleG, PrivacyType.PUBLIC);
//
//        User marioR = new User("mario","rossi","mario@gmail","12aas3",false,2);
//        posts.postMessage(marioR, PrivacyType.PUBLIC);
//
//        User ugo = new User("ugo","caciotta","ugo@gmail","12aas3",false,2);
//        posts.postMessage(ugo, PrivacyType.PUBLIC);
//
//        User pino = new User("pino","tavolino","pino@gmail","12aas3",false,2);
//        posts.postMessage(pino, PrivacyType.PUBLIC);
//
//        posts.showHomeMessages();










    }
}
