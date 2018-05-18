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

public class PreviewFile {
  private WebDriver driverCrome, driverFirefox;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private  Wait<WebDriver> waitCrome, waitFirefox;
  private Util util;

  @Before
  public void setUp() throws Exception {
    util = new Util();
    driverCrome = util.getDriverCrome();
    waitCrome = util.getWaitCrome();
    driverFirefox = util.getDriverFirefox();
    waitFirefox = util.getWaitFirefox();
  }

  private void doPreviewFile(WebDriver driver, Wait wait){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-label='ti.pdf']"))));
    driver.findElement(By.xpath("//div[@aria-label='ti.pdf']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='button' and @data-tooltip='Предварительный просмотр' and @aria-label='Предварительный просмотр']"))));
    driver.findElement(By.xpath("//div[@role='button' and @data-tooltip='Предварительный просмотр' and @aria-label='Предварительный просмотр']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[3]/div/div/div[3]/div"))));
    driver.findElement(By.xpath("//div[3]/div/div/div[3]/div")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("ok"))));
    driver.findElement(By.name("ok")).click();
    driver.quit();
  }

  @Test
  public void PreviewFileTest() throws Exception {
    util.auth(driverCrome,waitCrome);
    doPreviewFile(driverCrome, waitCrome);
    util.auth(driverFirefox,waitFirefox);
    doPreviewFile(driverFirefox,waitFirefox);
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
