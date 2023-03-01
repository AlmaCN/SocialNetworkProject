package firstTry;

import firstTry.entities.Database;
import firstTry.entities.Post;
import firstTry.entities.User;

public class Main {

    public static void main(String[] args) {

        User.register();

        User.login();

        Post.createPost(Database.users.get("gaia"));

    }

}
