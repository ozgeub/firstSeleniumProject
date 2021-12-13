package com.ozge.functions.commonfunctions;

import com.ozge.Variables.PageObjects;
import com.ozge.Variables.Variables;
import com.ozge.initialization.ProjectLog;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public interface NavigationController extends BrowserController  {


     default void navigateURL (String openURL) throws IOException {
        System.out.println("Browser Controller , Navigation controller method");
        in.driver.get(openURL);
        ProjectLog.logger.debug(openURL+"has been openned");
        Variables.pageTitle= in.driver.getTitle();
        checkText("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da",Variables.pageTitle);
        ProjectLog.logger.info("Page loaded successfully !");
    }

     default void closeFirstPopUp (String checkURL , String closeUrl) {
        System.out.println("CloseFirstPopup method , Navigation Controller");
        waitForLoad();
        waitForElementAppeared(checkURL);
        ProjectLog.logger.info("Pop - up page displays successfully");
        waitAndClick(closeUrl);

    }

     default void sendKeys(String elementXpath , String key) {
        in.driver.findElement(By.xpath(elementXpath)).sendKeys(key);
    }
    default void clearTextBox(String elementXpath) {
        in.driver.findElement(By.xpath(elementXpath)).clear();
    }

     default void navigateloginPopup(){
        System.out.println("loginUser method , Navigation Controller");
        // Check login button validation
        String temp = in.driver.findElement(By.xpath(PageObjects.loginContainer)).getAttribute("class");
        Assert.assertEquals(Variables.loginClassName,temp);
        //checkText(Variables.loginClassName,temp);
        ProjectLog.logger.info("Login button found successfully, lets click it!");
        Actions action = new Actions(in.driver);
        action.moveToElement(in.driver.findElement(By.xpath(PageObjects.loginContainer))).perform();
        //Check list box opened successfully or not
        action.moveToElement(in.driver.findElement(By.xpath(PageObjects.loginButton))).click().perform();
        // Check login pop-up opened successfully or not
        waitForElementAppeared(PageObjects.loginPage);
        ProjectLog.logger.info("Login pop-page opened successfully");

    }

     default void loginUser (String email , String password) {

        sendKeys(PageObjects.emailTextBox, email);
        sendKeys(PageObjects.passwordTxtBox, password);
        waitAndClick(PageObjects.loginSubmit);
        System.out.println("Successfully Login , after click");
        //Check user successfully login or not
       // checkText(Variables.afterLoginTxt, in.driver.findElement(By.xpath("//*[@id=\"logged-in-container\"]/span")).getAttribute("innerHTML"));
        ProjectLog.logger.info("Login operation has performed successfully !");
    }
    default String rtrnText (String elementXpath){
      return  in.driver.findElement(By.xpath(elementXpath)).getText();
    }
    default void waitFunc (long timeOut) throws InterruptedException {
        Thread.sleep(timeOut);
    }


  /*  void searchlist(String keyword , String path)
    {
        WebDriverWait wait = new WebDriverWait(in.driver, 30);
        WebElement searchlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        searchlist.sendKeys(keyword);
        searchlist.sendKeys(Keys.RETURN);
        Assert.assertEquals(1, in.driver.findElements(By.xpath("xpath [.='" + keyword + "']]")).stream().count(), "Verify keyword was found in the search results");

    } */

      /*static List  checkList (String elementXpath){
         List<WebElement> fltrList =in.driver.findElements(By.xpath(elementXpath));
         List <String> fltrListTxt = new ArrayList<>();

        for (int i = 0; i<fltrList.size(); i++) {
            fltrListTxt.add(fltrList.get(i).getText());

        }
          return  fltrList;
      } */

}
