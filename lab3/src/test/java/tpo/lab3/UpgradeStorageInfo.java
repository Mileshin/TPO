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
  private Util util;

  @Before
  public void setUp() throws Exception {
    util = new Util();
    driverCrome = util.getDriverCrome();
    waitCrome = util.getWaitCrome();
    driverFirefox = util.getDriverFirefox();
    waitFirefox = util.getWaitFirefox();
  }

  private void upgradeStorage(WebDriver driver, Wait wait) throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@data-target='upgrade-storage'])"))));
    driver.findElement(By.xpath("(//a[@data-target='upgrade-storage'])")).click();
    String winHandleBefore = driver.getWindowHandle();
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Подробнее')]"))));
    driver.findElement(By.xpath("//span[contains(text(),'Подробнее')]")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[contains(text(),'Подробнее...')])[2]"))));
    driver.findElement(By.xpath("(//a[contains(text(),'Подробнее...')])[2]")).click();
    winHandleBefore = driver.getWindowHandle();
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
    assertTrue(driver.getCurrentUrl().matches("^https://support\\.google\\.com/[\\s\\S]*$"));
    driver.quit();
  }


  @Test
  public void upgradeStorageTest() throws Exception {
    util.auth(driverCrome,waitCrome);
    upgradeStorage(driverCrome, waitCrome);
    util.auth(driverFirefox,waitFirefox);
    upgradeStorage(driverFirefox,waitFirefox);
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
