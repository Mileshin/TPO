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

public class DeleteFolder {
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

  private void CreateFolder(WebDriver driver, Wait wait){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button']"))));
    driver.findElement(By.xpath("//button[@guidedhelpid='new_menu_button']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(text(),'Папку')])"))));
    driver.findElement(By.xpath("(//div[contains(text(),'Папку')])")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']"))));
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).clear();
    driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']")).sendKeys("TestFolderTPOlab3");
    driver.findElement(By.name("ok")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-label='TestFolderTPOlab3']"))));
  }

  private void doDeleteFolder(WebDriver driver, Wait wait){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-label='TestFolderTPOlab3']"))));
    driver.findElement(By.xpath("//div[@aria-label='TestFolderTPOlab3']")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='button' and @data-tooltip='Удалить' and @aria-label='Удалить']"))));
    driver.findElement(By.xpath("//div[@role='button' and @data-tooltip='Удалить' and @aria-label='Удалить']")).click();
    driver.quit();
  }

  @Test
  public void deleteTableTest() throws Exception {
    util.auth(driverCrome,waitCrome);
    CreateFolder(driverCrome, waitCrome);
    doDeleteFolder(driverCrome, waitCrome);

    util.auth(driverFirefox,waitFirefox);
    CreateFolder(driverFirefox,waitFirefox);
    doDeleteFolder(driverFirefox,waitFirefox);
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
