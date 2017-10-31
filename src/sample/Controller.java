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
    private TextField file;

    @FXML
    private void enter(ActionEvent actionEvent) {
        driver = Player.start(login.getText(), password.getText());
    }

    @FXML
    private void play(ActionEvent event) {
        new Thread(() -> {
            while (history.isSelected()) {
                driver.navigate().refresh();
                History.remember(Parser.getRaund(driver.getPageSource()));
                Human.wait(15);
            }
        }).start();
    }

    @FXML
    private void selectFile(ActionEvent event) {
    }
}
