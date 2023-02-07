package it.develhope.team4.Entities;

import java.util.List;

public class User {
    public String name;
    public String surname;
    public String password;
    public String email;
    private String profileId;
    private boolean isBanned;
    private int userNumber;


    public User (){};

    public User(String name, String surname, String email, String profileId, boolean isBanned, int userNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profileId = profileId;
        this.isBanned = isBanned;
        this.userNumber = userNumber;
    }

    public User(String name, String surname, String email, String profileId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profileId = profileId;
    }




    public boolean getIsBanned() {
        return isBanned;
    }
    public void setBanned(boolean banned) {
        isBanned = banned;
    }
    public String getProfileId() {
        return profileId;
    }
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
    public int getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
}
