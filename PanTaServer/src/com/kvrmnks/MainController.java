package com.kvrmnks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
        data.add(new ViewUser(new User("43","fd")));
    }


    void setApp(Main app){
        application=app;
    }
}
