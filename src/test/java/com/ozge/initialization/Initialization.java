package com.ozge.initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Initialization  {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement webElement;
    public String BrowType;
    public Actions actions;
    public boolean testResult = false;



   public String browserType = null;

    public void init(String  browserType) {
        if (browserType == BrowserType.CHROME) {
            System.out.println("Initialization on init method");
            // will implement config.xml for drivers path
            System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            ProjectLog.logger.debug(browserType+"has not been initialized");
        } else if (browserType == BrowserType.FIREFOX) {
            System.setProperty("webdriver.firefox.driver", "D:\\FirefoxDriver\\firefoxdriver.exe");
            driver = new FirefoxDriver();
            ProjectLog.logger.debug(browserType+"has not been initialized");
        }else {
            ProjectLog.logger.error(browserType+"has not configured yet... ");
        }
    }

}
