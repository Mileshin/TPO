package tpo.lab3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrey on 15.05.2018.
 */
public class FirstTest {
        private static WebDriver driver;

        @BeforeClass
        public static void setup() {
            System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://drive.google.com");
        }

    @Test
    public void userLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Перейти к Google Диску']"));
        loginButton.click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testpass");
    }
}
