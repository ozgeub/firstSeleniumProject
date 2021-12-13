package com.ozge.functions.commonfunctions;

import com.ozge.initialization.Initialization;
import com.ozge.initialization.ProjectLog;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;


public interface BrowserController {

    Initialization in = new Initialization();

    public default void openBrowser (String browserType) {
        System.out.println("Browser Controller , openBrowser method.");
        in.init(BrowserType.CHROME);
        in.driver.manage().window().maximize();
        ProjectLog.logger.debug(browserType+"has been initialized");
    }

    public default void closeBrowser () throws IOException {
       System.out.println("Browser Controller , closeBrowser method.");
       in.driver.quit();
       Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
    }
    public default void checkText (String text , String value) throws IOException {
        System.out.println("Browser Controller , checkText method.");
        Assert.assertEquals(text,value);
    }

    public default void waitForElementAppeared (String elementXpath) {
       System.out.println("Browser Controller , waitForElementAppeared method.");
       WebDriverWait wait = new WebDriverWait(in.driver, 60);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));

    }
    public default void waitAndClick (String elementXpath) {
        System.out.println("Browser Controller , waitAndClick method.");
        WebDriverWait wait = new WebDriverWait(in.driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        in.driver.findElement(By.xpath(elementXpath)).click();
    }

    public default void waitURLAppeared () {
        System.out.println("Browser Controller , URL check");
        WebDriverWait wait = new WebDriverWait(in.driver, 60);
        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/butik/liste/1/kadin"));
        //in.driver.findElement(By.xpath(elementXpath)).click();
    }

    public default void waitForLoad() {
        System.out.println("Browser Controller , waitForLoad method.");
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(in.driver, 30);
        wait.until(pageLoadCondition);
        ProjectLog.logger.debug("Browser (" + in.driver
                .getWindowHandle() + ") has waited for the page to load.");

    }
}
