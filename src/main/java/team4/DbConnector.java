package team4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbConnector {

    private static String dbURL = "jdbc:mysql://localhost:3306/socialnetwork";
    private static String user = "developer";
    private static String password = "Developer01.02";

    public static void connectToDb(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbURL,user,password);

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM students");

            List<String> surnames = new ArrayList<>();

            while(result.next()){
                System.out.println(result.getString("first_name"));
                surnames.add(result.getString("last_name"));
            }

            System.out.println(surnames);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
