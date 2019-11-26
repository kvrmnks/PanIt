package com.kvrmnks;

import java.awt.image.DataBuffer;
import java.io.*;
import java.util.ArrayList;

public class UserManager implements Serializable {


    private DataBase dataBase = new DataBase();

    UserManager() {

    }

    private void save() {
        dataBase.save();
    }

    static String[] getUserNameAndPassword(String str) {
        return str.split("\\$");
    }

    boolean checkUser(String userName, String password) {
        return dataBase.has(new User(userName, password));
    }

    boolean checkUserByName(String userName){
        return dataBase.hasSameName(new User(userName,""));
    }

    void addUser(String userName,String password){
        dataBase.add(new User(userName,password));
    }
}
