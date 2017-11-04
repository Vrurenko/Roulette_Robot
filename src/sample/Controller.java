package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.openqa.selenium.WebDriver;

public class Controller {

    private WebDriver driver;

    @FXML private TextField login;
    @FXML private TextField password;
    @FXML private TextField amount;
    @FXML private CheckBox history;
    @FXML private CheckBox game;
    @FXML private TextField file;
    @FXML private Button playButton;
    @FXML private Button saveButton;

    @FXML
    private void enter(ActionEvent actionEvent) {
        driver = Player.start(login.getText(), password.getText());
        playButton.setVisible(true);
        saveButton.setVisible(true);
    }

    @FXML
    private void play(ActionEvent event) {
        new Thread(() -> {
            String prevColor = "";
            Integer prevRound = 0;
            Integer currentSeries = 1;

            while (history.isSelected() || game.isSelected()) {
                driver.navigate().refresh();

                String html = driver.getPageSource();
                Integer round = Parser.getRaund(html);
                String color = Parser.getLastColor(html);

                if (round > prevRound) {
                    if (color.equals(prevColor)) {
                        currentSeries++;
                    } else {
                        History.addSeries(currentSeries);
                        currentSeries = 1;
                        prevColor = color;
                    }
                    prevRound = round;
                }

                Integer finalCurrentSeries = currentSeries;
                String finalPrevColor = prevColor;
                Platform.runLater(() -> Main.setStageTitle("Current series is " + finalCurrentSeries + " of " + finalPrevColor));

                Human.wait(15);
            }
        }).start();
    }

    @FXML
    private void save(ActionEvent event) {
        History.saveSeries();
    }
}
