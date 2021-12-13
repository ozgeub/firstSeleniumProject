package com.ozge.testcases.Case1;

import com.ozge.Variables.PageObjects;
import com.ozge.Variables.Variables;
import com.ozge.functions.commonfunctions.BrowserController;
import com.ozge.functions.commonfunctions.NavigationController;
import com.ozge.initialization.ProjectLog;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CaseOne implements BrowserController, NavigationController {

    @BeforeMethod
    public void beforeMethod() throws IOException {
        openBrowser(BrowserType.CHROME);
        ProjectLog.logger.info("Here is the Page URL" + Variables.pageURL);
        navigateURL(Variables.pageURL);
        waitForLoad();
    }

    @Test
    public void loginCases() throws InterruptedException {

    //Success Login Scenario

        closeFirstPopUp(PageObjects.popupContainer, PageObjects.popupContainerClose);
        waitForLoad();
        navigateloginPopup();

        loginUser(Variables.userMail, Variables.userPassword);
        waitURLAppeared();
        System.out.println(in.driver.getCurrentUrl());

        // Should add valid email but not subscribed user case.
        // Should add "şifremi unuttum" button functionality*/
}

   @AfterMethod
    public void afterMethod() throws IOException {
        in.driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }


}
