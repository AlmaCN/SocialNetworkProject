package it.develhope.team4.Functions;


import it.develhope.team4.Entities.User;
import it.develhope.team4.Interfaces.PrivacyType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostMessage extends User {

    public List<String> messageList = new ArrayList<>();





    public String postMessage(User user, PrivacyType privacyType){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        Scanner sc = new Scanner(System.in);
        String sampleInput = sc.nextLine();
        String sampleMessage = user.name+" "+user.surname+"\n"+sampleInput+"\n"+time.format(dtf)+"\n";
        //System.out.println(sampleMessage);
        messageList.add(sampleMessage);

        return sampleMessage;

    }




}
