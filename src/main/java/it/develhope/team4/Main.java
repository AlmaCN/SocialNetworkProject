package it.develhope.team4;

public class Main {
    public static void main(String[] args) {

        User erza = new User();
        erza.newUser();
//        User natsu = new User();
//        natsu.newUser();
        System.out.println(User.users);
//        System.out.println(User.users.get("Natsu"));
        //System.out.println(erza.users.get(erza.randomUUID));



        //Post ciao = new Post();
        //ciao.postCreation(erza, "Ciao");
        //System.out.println(ciao.posts);
        //ciao.postModify();
        //ciao.postReaction(ReactionType.LIKE);

    }
}
