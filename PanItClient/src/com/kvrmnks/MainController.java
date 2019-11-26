package com.kvrmnks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
    public ContextMenu contextMenu;
    public MenuItem openMenuItem;
    public MenuItem downLoadMenuItem;
    public MenuItem renameMenuItem;
    public MenuItem removeMenuItem;
    public MenuItem bindMenuItem;
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

        fileTableView.setRowFactory(new Callback<TableView, TableRow>() {
            @Override
            public TableRow call(TableView param) {
                TableRow<ViewMyFile> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton() == MouseButton.SECONDARY) {
                            contextMenu.show(fileTableView, event.getScreenX(), event.getScreenY());
                        }
                    }
                });
                return row;
            }
        });

    }

    void setApp(Main app) {
        application = app;
    }

    void init() throws IOException {
        MyFile[] file = client.getStructure("/");
        for (MyFile mf : file) {
            data.add(new ViewMyFile(mf));
        }
    }

    void setClient(Socket s, DataInputStream dis, DataOutputStream dos) {
        client = new Client(dis, dos, s);
    }
}
