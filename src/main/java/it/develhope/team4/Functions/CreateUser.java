package it.develhope.team4.Functions;


import it.develhope.team4.Entities.User;

import java.util.*;

public class CreateUser {

    private static int userNumberCount = 0;
    public CreateUser (){};
    public HashMap<String, User> userList = new HashMap<>();

    private static void newUserNumberCount(){
        userNumberCount++;
    }

    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }

    public void stampaLista(){
        for (Map.Entry<String,User> x:userList.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue().name+" "+x.getValue().surname+
                    " "+x.getValue().email+" "+x.getValue().getIsBanned()+" "+
                    x.getValue().getUserNumber());
        }
    }

/** User creation con scanner */
    public User userRegistration() throws InterruptedException {

        /**Costruisco 1 user vuoto */
        User user = new User("","","","",false,0);
        System.out.println("Hi welcome to TikThope, in order to access our social you have to register: ");
        //Thread.sleep(200);

        /**Assegno name, surname e email tramite scanner */
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your name: ");
        user.name = sc.nextLine();
        //timer di abbellimento per fare finto loading
       // System.out.print("Loading."); Thread.sleep(500); System.out.print(".");Thread.sleep(500); System.out.print(".");Thread.sleep(500);System.out.print(".\n");
        System.out.println("Type your surname: ");
        user.surname = sc.nextLine();
        //System.out.print("Loading."); Thread.sleep(500); System.out.print(".");Thread.sleep(500); System.out.print(".");Thread.sleep(500);System.out.print(".\n");
        System.out.println("Type your email: ");
        user.email = sc.nextLine();
        System.out.println("Type your password: ");
        user.password = sc.nextLine();

        /**Assegno privatamente l'ID unico, il ban state, e il numero dell'user in ordine di creazione */
        //randomizer alfanumerico con scelta d inumero di caratteri
        //user.setProfileId(generateRandomChars("abcdefghilmnopqrstuvzwxyABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",17));
        UUID uuid = UUID.randomUUID();
        /**Dovrebbe controllare che la value (quindi la key unica dell'user non e' gia presente per un altro user) */
        user.setProfileId(String.valueOf(uuid));
        while(userList.containsKey(user.getProfileId())){
            UUID uuid2 = UUID.randomUUID();
            user.setProfileId(String.valueOf(uuid2));
        }
        user.setBanned(false);
        newUserNumberCount();
        user.setUserNumber(userNumberCount);
        //var fullData contiene tutti i valori - riutilizzabile x test
        //String fullData = user.name+ " " + user.surname + user.email+" "+user.getProfileId()+" "+user.getIsBanned()+user.getUserNumber();
        userList.putIfAbsent(user.getProfileId(),user);
        /**show dei valori attuali*/
       // System.out.println(" Name: "+user.name+"\n Surname: "+user.surname+"\n Email: "+user.email+"\n User private ID: "+user.getProfileId()+"\n Ban state: "+user.getIsBanned()+"\n User number #"+user.getUserNumber());
        stampaLista();
        return user;

    }


/** Creazione user da compiler */
    public User userRegistration2(String name, String surname, String email) throws InterruptedException {

        /**Costruisco 1 user vuoto */
        User user = new User("","","","",false,0);

        /**Assegno name, surname e email da parametro */
        user.name = name;
        user.surname = surname;
        user.email = email;
        boolean checkCorrectMail = true;
         while(checkCorrectMail) {
             if (email.contains("@")) {
                 checkCorrectMail = false;
                 /**Assegno privatamente l'ID unico, il ban state, e il numero dell'user in ordine di creazione */
                 //randomizer alfanumerico con scelta d inumero di caratteri
                 //user.setProfileId(generateRandomChars("abcdefghilmnopqrstuvzwxyABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",17));
                 UUID uuid = UUID.randomUUID();
                 /**Dovrebbe controllare che la value (quindi la key unica dell'user non e' gia presente per un altro user) */
                 user.setProfileId(String.valueOf(uuid));
                 while (userList.containsKey(user.getProfileId())) {
                     UUID uuid2 = UUID.randomUUID();
                     user.setProfileId(String.valueOf(uuid2));
                 }
                 user.setBanned(false);
                 newUserNumberCount();
                 user.setUserNumber(userNumberCount);
                 userList.putIfAbsent(user.getProfileId(), user);
                 //print di tutti i valori
                 // System.out.println(" Name: "+user.name+"\n Surname: "+user.surname+"\n Email: "+user.email+"\n User private ID: "+user.getProfileId()+"\n Ban state: "+user.getIsBanned()+"\n User number #"+user.getUserNumber());

                 return user;
             } else {
                 System.out.println("Wrong email address");
             }

         }
                return null;

    }








    //if(!userList.containsValue(user)) {
    //        userList.putIfAbsent(userInfo, formattedID);
    //        System.out.println(" Name: "+user.name+"\n Surname: "+user.surname+"\n Email: "+user.email+"\n User private ID: "+user.getProfileId()+"\n Profile ban state: "+user.getIsBanned()+"\n User numer #"+user.getUserNumber());
    //        System.out.println("current user list "+userList+"\n");
    //        return user;
    //        }else{
    //
    //            System.out.println("error occured try again");
    //        }



}
