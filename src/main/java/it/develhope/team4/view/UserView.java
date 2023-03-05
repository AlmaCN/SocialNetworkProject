package it.develhope.team4.view;

import it.develhope.team4.Control.Mysql;
import it.develhope.team4.Entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserView {


    Mysql manager;

    List<User> userList;




    public UserView(){
        Mysql manager = new Mysql();

    }


    public void GetAllUser() throws SQLException {
        manager.getAllUser();
    }






}

