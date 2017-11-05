package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.openqa.selenium.WebDriver;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML private TextField login;
    @FXML private TextField password;
    @FXML private TextField amount;
    @FXML private CheckBox history;
    @FXML private CheckBox game;
    @FXML private TextField file;
    @FXML private Button playButton;
    @FXML private Button saveButton;

    static WebDriver driver;

    @FXML
    private void enter(ActionEvent actionEvent) {
        driver = Player.login(login.getText(), password.getText());
        playButton.setVisible(true);
        saveButton.setVisible(true);
    }

    @FXML
    private void save(ActionEvent event) {
        History.saveSeries();
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
                    if (color.equals(prevColor) || color.equals("Yellow")) {
                        currentSeries++;
                    } else {
                        History.addSeries(currentSeries);
                        currentSeries = 1;
                        prevColor = color;
                    }
                    prevRound = round;
                }

                if (game.isSelected() && Parser.getBonuses(html) > 300) {
                    if (currentSeries == History.maxSeries) {
                        Human.putOn(Parser.getBonuses(html) / 3, prevColor);
                    }
                    if (currentSeries > History.maxSeries) {
                        Human.putOn(Parser.getBonuses(html), prevColor);
                    }
                }

                Integer finalCurrentSeries = currentSeries;
                String finalPrevColor = prevColor;
                Platform.runLater(() -> Main.setStageTitle("Current series is " + finalCurrentSeries + " of " + finalPrevColor));

                Human.wait(15);
            }
        }).start();

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        History.saveSeries();
                    }
                }, 60 * 60 * 1000, 60 * 60 * 1000);
    }
}
