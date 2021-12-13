package com.ozge.testcases.Case2;

import com.ozge.Variables.PageObjects;
import com.ozge.Variables.Variables;
import com.ozge.functions.commonfunctions.BrowserController;
import com.ozge.functions.commonfunctions.NavigationController;
import com.ozge.initialization.ProjectLog;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CaseTwo implements BrowserController, NavigationController {

    @BeforeMethod
    public void beforeMethod() throws IOException {
        openBrowser(BrowserType.CHROME);
        ProjectLog.logger.info("Here is the Page URL" + Variables.pageURL);
        navigateURL(Variables.pageURL);
        waitForLoad();
        closeFirstPopUp(PageObjects.popupContainer, PageObjects.popupContainerClose);
        waitForLoad();
        navigateloginPopup();
        loginUser(Variables.userMail, Variables.userPassword);
        waitURLAppeared();
        System.out.println("Completed beforeMethod " + "" + in.driver.getCurrentUrl());
    }

    @Test
    public void gamerComputer() throws IOException, InterruptedException {

        waitForElementAppeared(PageObjects.searchTextBox);
        sendKeys(PageObjects.searchTextBox, "Oyuncu Bilgisayarı");
        //waitAndClick(PageObjects.searchBtn);
        //System.out.println("Clicked ");
        waitAndClick(PageObjects.searchClick);
       // Assert.assertTrue(PageObjects.searchRsltChck.contains("Oyuncu Bilgisayarı"));


        // Marka Seçme
        waitForElementAppeared(PageObjects.markaTextBox);
        sendKeys(PageObjects.markaTextBox, "Monster");
        waitAndClick(PageObjects.markaCheckBox);
        waitForElementAppeared(PageObjects.brandValidation);
        Assert.assertEquals(in.driver.findElement(By.xpath(PageObjects.brandValidation)).getText(),
                "Monster");


        //Fiyat Aralığı
        Assert.assertTrue(PageObjects.fiyatText.contains("Fiyat"));
        waitAndClick(PageObjects.minFiyatTxtBox);
        sendKeys(PageObjects.minFiyatTxtBox, "3000");
        //waitAndClick(PageObjects.maxFiyatTxtBox);
        sendKeys(PageObjects.maxFiyatTxtBox, "15000");
        waitAndClick(PageObjects.fiyatBtn);
        waitForElementAppeared(PageObjects.priceValidation);
        Assert.assertEquals(in.driver.findElement(By.xpath(PageObjects.priceValidation)).getText(),"3000 TL - 15000 TL");


        waitAndClick(PageObjects.selectedUrun);
        waitForElementAppeared(PageObjects.sepeteAtBtn);
        waitAndClick(PageObjects.sepeteAtBtn);

    }
    @AfterMethod
    public void afterMethod() throws IOException {
        in.driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }
}


