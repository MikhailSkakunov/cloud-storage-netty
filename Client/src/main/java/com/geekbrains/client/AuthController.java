package com.geekbrains.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class AuthController {
    @FXML
    public Button authButton;
    @FXML
    public Button regButton;
    @FXML
    public CheckBox rememberMe;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void executeAuth() {
        String login = loginField.getText();
        char[] password = passwordField.getText().toCharArray();
        if (login == null || login.isBlank() || password.length == 0) {
            App.INSTANCE.getMainController().showAlert("Fields must be filled", Alert.AlertType.ERROR);
            return;
        }
        Network.getInstance().sendAuthMessage(login, password);
        App.INSTANCE.getMainController().rememberMeMenuItem.setSelected(rememberMe.isSelected());
    }

    public void registration() {
        App.INSTANCE.getRegStage().show();
    }
    // Вспомогательные методы для удобства навигации между полями

    public void loginFocus() {
        loginField.requestFocus();
    }

    public void submitLogin() {
        passwordField.requestFocus();
    }

    public void goFromLogin(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> regButton.requestFocus();
            case DOWN -> passwordField.requestFocus();
        }
    }

    public void goFromPassword(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> loginField.requestFocus();
            case DOWN -> authButton.requestFocus();
        }
    }

    public void goFromEnter(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> passwordField.requestFocus();
            case DOWN, LEFT -> regButton.requestFocus();
        }
    }

    public void goFromReg(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> passwordField.requestFocus();
            case DOWN -> loginField.requestFocus();
            case RIGHT -> authButton.requestFocus();
        }
    }

    public TextField getLoginField() {
        return loginField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setLoginField(String text) {
        loginField.setText(text);
    }

    public void setPasswordField(String text) {
        passwordField.setText(text);
    }
}

