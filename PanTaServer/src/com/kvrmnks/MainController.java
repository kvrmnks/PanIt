package com.kvrmnks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TextField nameTextField;
    public TextField passwordTextField;
    public Button addButton;
    private UserManager userManager;
    Main application;
    @FXML
    public TableView tableView;
    public TableColumn nameTableColumn;
    public TableColumn passwordTableColumn;
    ObservableList<ViewUser> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        passwordTableColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        tableView.setItems(data);
    }

    void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }


    void setApp(Main app) {
        application = app;
    }

    public void add(ActionEvent actionEvent) {
        if (userManager.checkUserByName(nameTextField.getText())) {
            MyAlert.showErrorAlert("同样的用户名已存在!");
        } else {
            userManager.addUser(nameTextField.getText(),passwordTextField.getText());
            data.add(new ViewUser(new User(nameTextField.getText(), passwordTextField.getText())));
            nameTextField.setText("");
            passwordTextField.setText("");
        }
    }
}
