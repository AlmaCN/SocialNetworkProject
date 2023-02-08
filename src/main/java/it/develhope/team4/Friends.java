package it.develhope.team4;

import java.util.ArrayList;
import java.util.List;

public class Friends {

    User user;


    List<User> friends = new ArrayList<>();


    public static void RequestFriends(List<User> friends, boolean acceptDeclineFriends) {
        if (acceptDeclineFriends) {
            User user = new User(null,null,null);
            friends.add(user);
        } else {
            System.out.println("user has been declined");


        }


    }

    public static void ShowListOfFriends(List<User> friends){
        for(int i=0; i<friends.size(); i++){
            System.out.println(i);
        }
    };

    public static void PrivateFriends(boolean isAPrivateFriend){

    }

    public static void RemoveFriends(List<User> friends){
        friends.remove(null);
    };



}


