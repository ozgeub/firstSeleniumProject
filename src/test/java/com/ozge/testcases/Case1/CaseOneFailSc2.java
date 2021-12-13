package com.ozge.testcases.Case1;

import com.ozge.Variables.PageObjects;
import com.ozge.Variables.Variables;
import com.ozge.functions.commonfunctions.BrowserController;
import com.ozge.functions.commonfunctions.NavigationController;
import com.ozge.initialization.ProjectLog;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CaseOneFailSc2 implements BrowserController, NavigationController {

    @BeforeMethod
    public void beforeMethod() throws IOException {
        openBrowser(BrowserType.CHROME);
        ProjectLog.logger.info("Here is the Page URL" + Variables.pageURL);
        navigateURL(Variables.pageURL);
        waitForLoad();
    }
    @Test
    //just entered password
    public void loginCases2() throws InterruptedException {
        System.out.println("Start to test execution");
        closeFirstPopUp(PageObjects.popupContainer, PageObjects.popupContainerClose);
        waitForLoad();
        navigateloginPopup();

        sendKeys(PageObjects.passwordTxtBox, "111");
        waitAndClick(PageObjects.loginSubmit);
        waitForElementAppeared(PageObjects.loginErrorPth);
        Assert.assertEquals(rtrnText(PageObjects.loginErrorPth),PageObjects.loginErrorMsg);
        waitAndClick(PageObjects.passwordTxtBox);
        clearTextBox(PageObjects.passwordTxtBox);
        waitFunc(1000);
    }
    @AfterMethod
    public void afterMethod() throws IOException {
        in.driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }
}
