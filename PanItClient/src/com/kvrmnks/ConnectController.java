package com.kvrmnks;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class ConnectController implements Initializable{
    public Button connectButton,closeButton;
    public TextField ipTextField,portTextField;
    private Main application;
    public void setApp(Main app){
        application = app;
    }
    public void initialize(URL location, ResourceBundle resources){

    }
    public void connect(ActionEvent actionEvent){

        try {
            String ip = ipTextField.getText();
            int port = Integer.parseInt(portTextField.getText());
            Socket socket = new Socket(ip,port);
            application.setLoginForm(socket);
        }
        catch (NumberFormatException e){
            MyAlert.showErrorAlert("端口格式有误");
        }
        catch (UnknownHostException e){
            MyAlert.showInformationAlert("找不到服务器");
        }
        catch (IOException e) {
            e.printStackTrace();
            MyAlert.showErrorAlert("无法连接");
        }

    }
    public void close(ActionEvent actionEvent){
        Platform.exit();
    }
}

