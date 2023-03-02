package team4;

import team4.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<User> users = new ArrayList<>();
    static List<Command> commands = new ArrayList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        User thisUser = null;

        commands.add(new Command("exit"));
        commands.add(new Command("register"));
        commands.add(new Command("login"));
        commands.add(new Command("post"));
        commands.add(new Command("comment"));
        commands.add(new Command("reaction"));

        commands.add(new Command("search user"));
        commands.add(new Command("search post"));
        //aggiungere anche vedere i miei post e implementare nello switch finale i comandi mancanti

        users.add(new User("Gaia", "Zanchi", "gaiaazanchi", "gaia@gmail.com", "gaia"));
        users.add(new User("Lorenzo", "Rossini", "lorenzoros","lore@gmail.com", "lorenzo"));

        System.out.println("Benvenuto nel nostro social!");
        String chosen = "";
        boolean continueOrNot = false;

        do {
            System.out.println("Vuoi registrarti (register), fare il login (login) o uscire (exit)?");
            chosen = s.nextLine().toLowerCase();
            Command com = new Command(chosen);

            switch (com.getDescription()) {
                case "register" -> {
                    thisUser = com.register();
                    continueOrNot = true;
                    break;
                }
                case "login" -> {
                    thisUser = com.login();
                    continueOrNot = true;
                    break;
                }
                case "exit" -> {
                    System.out.println("Arrivederci!");
                    return;
                }
                default -> System.out.println("Comando non esistente, riprova!");
            }

        }while(!continueOrNot);

        String command = "";

        //ora lo user che mi serve, che sta accedendo alle funzioni è thisUser
        while(true){
            System.out.println("I comandi disponibili sono: ");

            //devo filtrare con stream per togliere register e login poi li stampo
            List<Command> newCommList = commands.stream().filter(elem ->{
                return !elem.getDescription().equalsIgnoreCase("register") && !elem.getDescription().equalsIgnoreCase("login");
            }).toList();

            System.out.print("- ");
            for(Command c : newCommList){
                System.out.print(c + " - ");
            }
            System.out.println();

            System.out.println("Che cosa vuoi fare? Inserisci il comando!");
            command = s.nextLine().toLowerCase();
            Command comm1 = new Command(command);

            switch (command) {
                case "exit" ->{
                    System.out.println("Arrivederci!");
                    return;
                }
                case "post" -> {
                    comm1.createPost(thisUser);
                    break;
                }
                case "comment" -> {
                    comm1.comment(thisUser);
                    break;
                }
                case "reaction" -> {
                    comm1.react(thisUser);
                    break;
                }
                case "search" -> {
                    //da fare e dividere
                }
                default -> System.out.println("Comando non esistente, riprova!");
            }
        }

    }

}
