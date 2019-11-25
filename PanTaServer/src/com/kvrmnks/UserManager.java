package com.kvrmnks;

import java.awt.image.DataBuffer;
import java.io.*;
import java.util.ArrayList;

public class UserManager implements Serializable {



    private DataBase dataBase = new DataBase();

    UserManager(){

    }

    private void save(){
        dataBase.save();
    }

    static String[] getUserNameAndPassword(String str){
        return str.split("\\$");
    }
    boolean checkUser(String userName,String password){
        return dataBase.has(new User(userName,password));
    }
}
