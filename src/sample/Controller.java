package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private TextField amount;


    @FXML
    private void enter(ActionEvent event) {
        Player.start(login.getText(), password.getText());
    }

    @FXML
    private void play(ActionEvent event) {

    }
}
