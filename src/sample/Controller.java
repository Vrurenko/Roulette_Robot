package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.openqa.selenium.WebDriver;

public class Controller {

    private WebDriver driver;

    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private TextField amount;
    @FXML
    private CheckBox history;
    @FXML
    private CheckBox game;

    @FXML
    private void enter(ActionEvent event) {
        driver = Player.start(login.getText(), password.getText());
    }

    @FXML
    private void play(ActionEvent event) {
        new Thread(() -> {
            while (history.isSelected()) {
                driver.navigate().refresh();
                Human.wait(5);
            }
        }).start();
    }
}
