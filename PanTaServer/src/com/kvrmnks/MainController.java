package com.kvrmnks;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    Main application;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void setApp(Main app){
        application=app;
    }
}
