package it.develhope.team4.withSql.database;

public class Database {

    /**
     * Ho aggiunto le variabili dburl, userdb e passworddb, e le ho fatte private statiche e finali.
     */
    private static final String dburl = "jdbc:mysql://localhost:3306/socialnetwork";
    private static final String userdb = "developer";
    private static final String passworddb = "DeVe1234@#";

    //Getter per accedere a 'dburl', 'userdb' e 'passworddb'.
    public String getDbUrl(){
        return dburl;
    }

    public String getUserDb(){
        return userdb;
    }

    public String getPasswordDb(){
        return passworddb;
    }

}
