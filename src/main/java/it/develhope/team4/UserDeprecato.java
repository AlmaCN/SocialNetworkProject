package it.develhope.team4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
@Deprecated
public class UserDeprecato {

    public String name;
    public String surname;
    public String username;
    public String email;
    public String password;
    //    public DateTimeFormatter birthDate;
//    public int age;
    public boolean isBlocked;
    public UUID randomUUID;
    //List<User> users;

    static HashMap<String, UUID> users = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    public void newUser() {
        System.out.println("Enter your name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your surname: ");
        this.surname = sc.nextLine();
        System.out.println("Enter your username: ");
        this.username = sc.nextLine();
        System.out.println("Enter your email: ");
        this.email = sc.nextLine();

        //emailCheckerFirst();

        System.out.println("Enter your password");
        this.password = sc.nextLine();
        this.isBlocked = false;
        randomUUID = UUID.randomUUID();

        System.out.println("Benvenuto " + username);
        users.put(username, randomUUID);
    }


    public void emailCheckerFirst() {
        boolean emailCorrect = true;
        while (emailCorrect) {
            if (!email.contains("@") || email.contains("\\s+")) {
                emailCorrect = false;
                System.out.println("Email incorrect");
                System.out.println("Enter your email again: ");
                sc.nextLine();
            } else {
                System.out.println("Email correct");
            }
        }
    }

    public String postCreation() {
        Post post = new Post();
        post.postCreation(post.username, post.message);
        return post.message;
    }
}
