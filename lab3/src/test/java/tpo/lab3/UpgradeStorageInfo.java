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
import static junit.framework.TestCase.assertTrue;

public class UpgradeStorageInfo {
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
    /*driverFirefox = new FirefoxDriver();
    driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    waitFirefox = new WebDriverWait(driverFirefox, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
  */}

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

  private void upgradeStorage(WebDriver driver, Wait wait) throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-target='upgrade-storage'])"))));
    driver.findElement(By.xpath("(//a[@data-target='upgrade-storage'])")).click();
    String winHandleBefore = driver.getWindowHandle();
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'Подробнее...')])"))));
    driver.findElement(By.xpath("//a[contains(text(),'Подробнее...')]")).click();
    assertTrue(driver.getCurrentUrl().matches("^https://support\\.google\\.com/[\\s\\S]*$"));
    driver.quit();
  }


  @Test
  public void upgradeStorageTest() throws Exception {
    auth(driverCrome,waitCrome);
    upgradeStorage(driverCrome, waitCrome);

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
