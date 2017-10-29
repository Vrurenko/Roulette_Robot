package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

class Player {
    private static final String DRIVER = "C:\\Users\\Comandante\\Desktop\\Roulette Robot\\src\\libs\\chromedriver.exe";

    void start(String mail, String pass) {
        System.setProperty("webdriver.chrome.driver", DRIVER);
        WebDriver driver = new ChromeDriver();

        driver.get("https://dotamix.com/double");
        wait(3);

        WebElement vk = driver.findElement(By.className("landing-link-soc"));

        new Actions(driver).moveToElement(vk).click().perform();

        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("pass")).sendKeys(pass);
        driver.findElement(By.id("install_allow")).click();

        driver.get("https://dotamix.com/double");

    }

    private void wait(int time){
        try {
            Robot robot = new Robot();
            robot.delay(time*1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
