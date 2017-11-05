package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.*;

class Human {
    private static final String file = "C:\\Users\\Comandante\\Desktop\\Roulette Robot\\resources\\history.txt";

    static void wait(int time){
        try {
            Robot robot = new Robot();
            robot.delay(time*1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static void write(String text) {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true), true)) {
            printStream.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void putOn(int amount, String seriesColor) {
        if (seriesColor.equals("Green")) {
            putOnRed(amount);
        } else {
            putOnGreen(amount);
        }
    }

    private static void putOnGreen(int amount) {
        setAmount(amount);
        WebElement green = Controller.driver.findElement(By.xpath("//a[@data-rate='green']"));
        Actions action = new Actions(Controller.driver);
        action.moveToElement(green).click().perform();
    }

    private static void putOnRed(int amount){
        setAmount(amount);
        WebElement red = Controller.driver.findElement(By.xpath("//a[@data-rate='red']"));
        Actions action = new Actions(Controller.driver);
        action.moveToElement(red).click().perform();
    }

    private static void setAmount(int amount){
        WebElement element = Controller.driver.findElement(By.id("input_sum"));
        element.sendKeys(String.valueOf(amount));
    }

    static int calculateAmount(int balance) {
        return balance / 3;
    }
}
