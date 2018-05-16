package tpo.lab3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest {
  private WebDriver driverCrome, driverFirefox;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private  Wait<WebDriver> waitCrome, waitFirefox;
  private Util util;
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
    driverFirefox = new FirefoxDriver();
    driverCrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    waitCrome = new WebDriverWait(driverCrome, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    waitFirefox = new WebDriverWait(driverFirefox, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
  }

  private void doSuccessfulLogin(WebDriver driver, Wait wait) throws InterruptedException {
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
    driver.quit();
  }

  @Test
  public void successfulLogin() throws Exception {
    doSuccessfulLogin(driverCrome, waitCrome);
    doSuccessfulLogin(driverFirefox,waitFirefox);
  }

  private void doWrongLogin(WebDriver driver, Wait wait){
    driver.get(baseUrl);
    driver.findElement(By.xpath("//div[2]/div/a")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])"))));
    driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).clear();
    driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).sendKeys("test");
    driver.findElement(By.xpath("(//span[contains(text(),'Далее')])")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'Не удалось найти аккаунт Google')])"))));
    //driver.findElement(By.xpath("//div[contains(text(),'Не удалось найти аккаунт Google')]")).click();
    driver.quit();
  }

  @Ignore
  @Test
  public void wrongLogin() throws Exception {
    doWrongLogin(driverCrome, waitCrome);
    doWrongLogin(driverFirefox,waitFirefox);
  }

  private void doWrongPassword(WebDriver driver, Wait wait) throws InterruptedException {
    driver.get(baseUrl);

    driver.findElement(By.xpath("//div[2]/div/a")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])"))));
    driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).clear();
    driver.findElement(By.xpath("(//input[contains(@name, 'identifier')])")).sendKeys(correctLogin);
    driver.findElement(By.xpath("(//span[contains(text(),'Далее')])")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@name='password'])"))));
    driver.findElement(By.xpath("(//input[@name='password'])")).clear();
    driver.findElement(By.xpath("(//input[@name='password'])")).sendKeys("test");
    driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@name='password'])"))));
    driver.quit();
  }

  @Ignore
  @Test
  public void wrongPassword() throws Exception {
    doWrongPassword(driverCrome, waitCrome);
    doWrongPassword(driverFirefox,waitFirefox);
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
