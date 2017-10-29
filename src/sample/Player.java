package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Player {

    void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Comandante\\Desktop\\Roulette Robot\\src\\libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://dotamix.com/double");
    }

}
