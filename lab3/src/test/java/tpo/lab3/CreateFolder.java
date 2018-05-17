package tpo.lab3;


import org.junit.Before;
import org.junit.Test;
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

public class CreateFolder {
  private WebDriver driverCrome, driverFirefox;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private  Wait<WebDriver> waitCrome, waitFirefox;
  private String baseUrl, loginUrl;
  private String correctLogin = "andrejmileshin97@gmail.com";
  private String correctPassword = "1234567890df";

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/user/Desktop/chromedriver.exe");
    System.setProperty("webdriver.gecko.driver", "/Users/user/Desktop/geckodriver.exe");
    loginUrl = "https://www.google.com/intl/ru/drive/";
    baseUrl = "https://drive.google.com";
    driverCrome = new ChromeDriver();
    driverCrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    waitCrome = new WebDriverWait(driverCrome, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    driverFirefox = new FirefoxDriver();
    driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    waitFirefox = new WebDriverWait(driverFirefox, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
  }

  private void auth(WebDriver driver, Wait wait) throws InterruptedException {
    driver.get(baseUrl);

    driver.findElement(By.xpath("//div[2]/div/a")).click();
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

  public void doCreateFolderOk(WebDriver driver, Wait wait){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button']"))));
    driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'Папку')])"))));
    driver.findElement(By.xpath("(//div[contains(text(),'Папку')])")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']"))));
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).clear();
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).sendKeys("TestFolderTPOlab3");
    driver.findElement(By.name("ok")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-label='TestFolderTPOlab3']"))));
    driver.quit();
  }


  @Test
  public void CreateTFolderOkTest() throws Exception {
    auth(driverCrome,waitCrome);
    doCreateFolderOk(driverCrome, waitCrome);
    auth(driverFirefox,waitFirefox);
    doCreateFolderOk(driverFirefox,waitFirefox);
  }


  public void doCreateFolderCancel(WebDriver driver, Wait wait){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button and @aria-label='Создать']"))));
    driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button and @aria-label='Создать']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'Папку')])"))));
    driver.findElement(By.xpath("(//div[contains(text(),'Папку')])")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']"))));
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).clear();
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).sendKeys("TestFolderTPOlab3");
    driver.findElement(By.name("cancel")).click();
    driver.quit();
  }

  @Test
  public void CreateFolderCancelTest() throws Exception {
    auth(driverCrome,waitCrome);
    doCreateFolderCancel(driverCrome, waitCrome);
    auth(driverFirefox,waitFirefox);
    doCreateFolderCancel(driverFirefox,waitFirefox);
  }

 /* @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}
