package com.kvrmnks;

import javafx.fxml.Initializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Main application;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    void setApp(Main app){
        application = app;
    }
    void setInternet(Socket s,DataInputStream dis,DataOutputStream dos){
        socket = s;
        in = dis;
        out = dos;
    }
}
