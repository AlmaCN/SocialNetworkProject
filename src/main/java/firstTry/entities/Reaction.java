package firstTry.entities;

public class Reaction {

    Reactions reactionType;
    String username; //chi ha messo la reaction

    public Reaction(Reactions reactionType, String username){
        this.reactionType = reactionType;
        this.username = username;
    }

    //postId lo puoi trovare facendo una ricerca nella lista di post dell'utente (da migliorare)
    public static void addReaction(String postId, Reactions reactionType, String username){
        Reaction reaction = new Reaction(reactionType, username);
        Database.allPosts.forEach((post) -> {
            if(post.idPost.equals(postId)){
                post.reactions.add(reaction);
            }
        });
    }

    /*public void addLike(String postId){
        Reaction like = new Reaction(Reactions.LIKE, "gaia");
        Database.allPosts.forEach((post) -> {
            if(post.idPost.equals(postId)){
                post.reactions.add(like);
            }
        });
    }

    public void addAngry(String postId){
        Reaction angry = new Reaction(Reactions.ANGRY, "gaia");
        Database.allPosts.forEach((post) -> {
            if(post.idPost.equals(postId)){
                post.reactions.add(angry);
            }
        });
    }

    public void addRedHeart(String postId){
        Reaction heart = new Reaction(Reactions.REDHEART, "gaia");
        Database.allPosts.forEach((post) -> {
            if(post.idPost.equals(postId)){
                post.reactions.add(heart);
            }
        });
    }*/

}
