package com.kvrmnks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TableView fileTableView;
    public TableColumn fileTypeTableColumn;
    public TableColumn fileNameTableColumn;
    public TableColumn fileSizeTableColumn;
    public TableColumn fileModifyTimeTableColumn;
    private Main application;
    private Client client;
    private ObservableList<ViewMyFile> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        fileNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fileSizeTableColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        fileModifyTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("modifyTime"));
        fileTableView.setItems(data);
    }

    void setApp(Main app) {
        application = app;
    }

    void init() throws IOException {
        MyFile[] file = client.getStructure("/");
        for(MyFile mf : file){
            data.add(new ViewMyFile(mf));
        }
    }

    void setClient(Socket s, DataInputStream dis, DataOutputStream dos) {
        client = new Client(dis,dos,s);
    }
}
