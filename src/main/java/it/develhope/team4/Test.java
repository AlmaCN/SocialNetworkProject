package it.develhope.team4;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        System.out.println("Enter text here");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        Scanner scanner = new Scanner(System.in);

        String post = scanner.next();

        LocalDateTime now = LocalDateTime.now();

        switch (post) {
            case "like" -> {
                System.out.println("Used: Like reaction");
                System.out.println("Post successfully created");
                System.out.println(dtf.format(now));
            }
            case "hug" -> {
                System.out.println("Used: Hug reaction");
                System.out.println("Post successfully created");
                System.out.println(dtf.format(now));
            }
            case "angry" -> {
                System.out.println("Used: Angry reaction");
                System.out.println("Post successfully created");
                System.out.println(dtf.format(now));
            }
            default -> {
                System.out.println("No reaction used");
                System.out.println("Post successfully created");
                System.out.println(dtf.format(now));
            }
        }
    }
}