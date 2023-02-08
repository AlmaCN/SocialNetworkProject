package it.develhope.team4;

public class Post {
    public enum Reaction {
        Love,
        Haha,
        Sad,
        Wow,
        Sigh,
        Grr
    }

    public  void mood(String mood , Reaction reaction){};

    public  void PictureOrVideo(String bio, Reaction reaction){};

    public  void Stories(String comment, Reaction reaction){};


}


