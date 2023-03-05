package it.develhope.team4.Control;

import it.develhope.team4.Entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
    final String host = " jdbc:mysql://localhost:3306/newdb";
    final String user = "developer";
    final String password = "password";

    Connection conn;
    Statement statement;

    public Mysql() {
        try {
            Connection conn = DriverManager.getConnection(host, user, password);
        } catch (Exception e) {
            System.out.println("connessione riuscita");
        }


    }

    public void getAllUser() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM USER");
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            User u = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("email"),
                    rs.getString("nickname"));
            userList.add(u);
        }


    }
}

