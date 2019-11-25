package com.kvrmnks;

import javafx.beans.property.SimpleStringProperty;

public final class ViewUser {
    private final SimpleStringProperty name;
    private final SimpleStringProperty password;
    public ViewUser(User a){
        name = new SimpleStringProperty(a.getName());
        password = new SimpleStringProperty(a.getPassword());
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
