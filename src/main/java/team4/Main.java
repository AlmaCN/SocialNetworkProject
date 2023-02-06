package team4;

import it.develhope.socialProject.team4.entities.*;

public class Main {

    public static void main(String[] args) {

        User.register();

        User.login();

        Post.createPost(Database.users.get("gaia"));

    }

}
