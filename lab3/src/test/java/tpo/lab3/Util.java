package tpo.lab3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrey on 16.05.2018.
 */
public class Util {
    public String getBaseUrl() {
        return baseUrl;
    }

    private String baseUrl, loginUrl;
    private String correctLogin = "andrejmileshin97@gmail.com";
    private String correctPassword = "1234567890df";
    private  Wait<WebDriver> wait;

    public String getCorrectLogin() {
        return correctLogin;
    }

    public String getCorrectPassword() {
        return correctPassword;
    }

    public Util() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "//Users/user/Desktop/geckodriver.exe");
        loginUrl = "https://www.google.com/intl/ru/drive/";
        baseUrl = "https://drive.google.com";
       }

    public void prepare(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        driver.get(getBaseUrl());
    }

    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tryClick(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

//        element.click();
        element.sendKeys(Keys.ENTER);
    }

    public void auth(WebDriver driver, String login, String password) throws InterruptedException {
        driver.findElement(By.xpath("//div[2]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])"))));
        driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).clear();
        driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).sendKeys(correctLogin);
        driver.findElement(By.xpath("//div[2]/div/div/content/span")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[contains(@name, 'password')])"))));
        driver.findElement(By.xpath("(//input[contains(@name, 'password')])")).clear();
        driver.findElement(By.xpath("(//input[contains(@name, 'password')])")).sendKeys(correctPassword);
        driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
    }
}

