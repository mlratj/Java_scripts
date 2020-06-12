package org.example.exceptions;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException() {
        super("Validation error...");
    }
    private Alert createAlert(String title, String header, String content,
                              Alert.AlertType alertType) {
        final Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.OK);
        return alert;
    }
    private boolean handleAuthCall(String email, String password) throws
            ValidationException, IOException {
        if (StringUtils.isBlank(email)) {
            throw new ValidationException();
        } //if
        if (StringUtils.isBlank(password)) {
            throw new ValidationException();
        } //if
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/api/v1/authenticate");
        ObjectMapper objectMapper = new ObjectMapper();
        StringEntity requestEntity = new StringEntity(
                objectMapper.writeValueAsString(
                        new AuthenticationRequest().email(email).password(password)
                ),
                ContentType.APPLICATION_JSON
        );
        httpPost.setEntity(requestEntity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(httpPost);
        if (response == null) {
            return false;
        } //if
        if (response.getStatusLine() == null) {
            return false;
        } //if
        return (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK);
    }
    private void handleLoginClick(ActionEvent actionEvent) {
        try {
            if (this.pfPassword == null) {
                return;
            } //if
            if (this.tfEmailAddress == null) {
                return;
            } //if
            if (this.handleAuthCall(this.tfEmailAddress.getText(),
                    this.pfPassword.getText())) {
                createAlert(
                        "Login - success",
                        "Success",
                        "Logged in.",
                        Alert.AlertType.INFORMATION
                ).showAndWait();
            } else { //if
                createAlert(
                        "Login - error",
                        "Warning",
                        "Invalid login or password.",
                        Alert.AlertType.WARNING
                ).showAndWait();
            } //else
        } catch (ValidationException ex) {
            createAlert(
                    "Login - warning",
                    "Warning",
                    "Please provide email and password.",
                    Alert.AlertType.WARNING
            ).showAndWait();
        } catch (Exception ex) {
            createAlert(
                    "Login - error",
                    "Error",
                    "I am sorry, app had crushed.",
                    Alert.AlertType.ERROR
            ).showAndWait();
        }
    }
    @FXML
    private void initialize() {
        if (this.btnLogin != null) {
            this.btnLogin.setOnAction(this::handleLoginClick);
        }
    }
}
