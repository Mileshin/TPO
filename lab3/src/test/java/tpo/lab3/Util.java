package tpo.lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrey on 18.05.2018.
 */
public class Util {
    private WebDriver driverCrome, driverFirefox;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private Wait<WebDriver> waitCrome, waitFirefox;
    private String baseUrl, loginUrl;
    private String correctLogin = "andrejmileshin97@gmail.com";
    private String correctPassword = "1234567890df";

    public WebDriver getDriverCrome(){
        return driverCrome;
    }

    public WebDriver getDriverFirefox(){
        return driverFirefox;
    }

    public Wait<WebDriver> getWaitCrome(){
        return waitCrome;
    }

    public Wait<WebDriver> getWaitFirefox(){
        return waitFirefox;
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String getLoginUrl(){
        return loginUrl;
    }

    public String getCorrectLogin(){
        return correctLogin;
    }

    public String getCorrectPassword(){
        return correctPassword;
    }


    public void auth(WebDriver driver, Wait wait) throws InterruptedException {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'Перейти к Google Диску')])[4]"))));
        driver.findElement(By.xpath("(//a[contains(text(),'Перейти к Google Диску')])[4]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])"))));
        driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).clear();
        driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).sendKeys(correctLogin);
        driver.findElement(By.xpath("(//span[contains(text(),'Далее')])")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@name='password'])"))));
        driver.findElement(By.xpath("(//input[@name='password'])")).clear();
        driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys(correctPassword);
        driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//header[@id='gb']/div[2]/div/div[4]/div/a/span"))));
    }



    public Util(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "/Users/user/Desktop/geckodriver.exe");
        loginUrl = "https://www.google.com/intl/ru/drive/";
        baseUrl = "https://drive.google.com";
        driverCrome = new ChromeDriver();
        driverCrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        waitCrome = new WebDriverWait(driverCrome, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    //    driverFirefox = new FirefoxDriver();
    //    driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //    waitFirefox = new WebDriverWait(driverFirefox, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }
}
