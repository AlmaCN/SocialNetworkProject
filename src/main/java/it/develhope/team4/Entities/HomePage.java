package it.develhope.team4.Entities;


import it.develhope.team4.Functions.PostMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage extends PostMessage {

    public List<String> homePost = new ArrayList<>();



    public void showHomeMessages() {
    for (int i = 0; i < messageList.size(); i++) {
        System.out.println(messageList.get(i));
    }
}


}









