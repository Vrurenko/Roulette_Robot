package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private TextField amount;

    @FXML
    private void num(ActionEvent event) {
        password.setText(login.getText());
    }

    @FXML
    private void locateFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        System.out.println(file);
    }

    @FXML
    private void test(ActionEvent event) {
        new Player().start();
    }


}
