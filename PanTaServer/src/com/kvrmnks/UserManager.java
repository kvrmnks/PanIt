package com.kvrmnks;

public class UserManager {
    static String[] getUserNameAndPassword(String str){
        return str.split("\\$");
    }
    boolean checkUser(String userName,String password){
        return true;
    }
}
