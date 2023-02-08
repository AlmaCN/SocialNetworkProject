package it.develhope.team4;

import java.util.List;

public class Home {

        public void Update(List<Post> post){
            for(int i=0; i<post.size(); i++){
                System.out.println(i);
            }
        };

        public void Search(String search, User user){
            if (search == user.getUsername()){
                System.out.println("user found");
                user.UserGetDetails();
            }else{
                System.out.println("user not found");
            }


        };

        public void Share(){};
    }



