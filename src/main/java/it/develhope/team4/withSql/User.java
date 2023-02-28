package it.develhope.team4.withSql;

public class User {

    private String idUser;
    private String nameUser;
    private String surnameUser;
    private String emailUser;
    private String passwordUser;
    private String nicknameUser;

    //Setters
    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }

    public void setSurnameUser(String surnameUser){
        this.surnameUser = surnameUser;
    }

    public void setEmailUser(String emailUser){
        this.emailUser = emailUser;
    }


    public void setPasswordUser(String passwordUser){
        this.passwordUser = passwordUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    //Getters
    public String getNameUser(){
        return nameUser;
    }

    public String getSurnameUserUser(){
        return surnameUser;
    }

    public String getEmailUser(){
        return emailUser;
    }

    public String getPasswordUser(){
        return passwordUser;
    }

    public String getNicknameUser(){
        return nicknameUser;
    }
}
