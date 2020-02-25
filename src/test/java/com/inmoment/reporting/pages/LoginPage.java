package com.inmoment.reporting.pages;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends PageBase {
    private  WebDriver driver = Driver.getDriver();
    private  By emailLocator = By.cssSelector("input#mat-input-0");
    private  By passwordLocator = By.cssSelector("input#mat-input-1");
    private  By loginButtonLocator = By.cssSelector("div[class=button-text]");
    private  By hertzCXLocator = By.cssSelector("div[class=account-program-wrapper]");
    private By headingMessage = By.xpath("//div[@class='super-heading-message']");
    private  By userDropDown = By.xpath("//div[@class='arrow-wrapper ng-tns-c15-4 ng-star-inserted']");
    private  By NPSProgram = By.xpath("//div[contains(text(),'Hertz - NPS Program')]");
    private By menuIconsDropdown = By.xpath("//div[@class='sc-jlyJG ekQpXr']");
    private By reportingIcon = By.xpath("//li[@class='basic-tile-wrapper ng-tns-c12-10 ng-star-inserted']//div[@class='tile-text-wrapper'][contains(text(),'Reporting')]");
    private By pageOverlay = By.xpath("//div[@class='cdk-overlay-backdrop dark-backdrop cdk-overlay-backdrop-showing']");



    public void loginSuccessfully (String username, String password) throws InterruptedException {
        seleniumutil.goToPage(seleniumutil.getProperty("reportingPageUrl"));
        waitForPageLoaded();
        seleniumutil.click(emailLocator);
        seleniumutil.sendKEys(emailLocator, username);
        seleniumutil.click(passwordLocator);
        seleniumutil.sendKEys(passwordLocator , password);
        seleniumutil.click(loginButtonLocator);
        waitForPageLoaded();
        System.out.println(driver.getCurrentUrl());
        seleniumutil.waitForElementVisible(hertzCXLocator);
        seleniumutil.assertIsDisplayed(hertzCXLocator);
        seleniumutil.deleteCookies();
    }
    public void loginSuccessfully() throws InterruptedException {
        seleniumutil.goToPage(seleniumutil.getProperty("reportingPageUrl"));
        waitForPageLoaded();
        seleniumutil.click(emailLocator);
        seleniumutil.sendKEys(emailLocator, seleniumutil.getProperty("loginEmailJoe"));
        seleniumutil.click(passwordLocator);
        seleniumutil.sendKEys(passwordLocator , seleniumutil.getProperty("loginPasswordJoe"));
        seleniumutil.click(loginButtonLocator);
        waitForPageLoaded();
        System.out.println(driver.getCurrentUrl());
        seleniumutil.waitForElementVisible(hertzCXLocator);
        seleniumutil.assertIsDisplayed(hertzCXLocator);
        seleniumutil.deleteCookies();
    }
    public void goToNPSProgram() throws InterruptedException {
        loginSuccessfully();
        waitForPageLoaded();
        System.out.println("1");
        seleniumutil.waitForElementVisible(userDropDown);
        seleniumutil.click(userDropDown);
        System.out.println("2");
        seleniumutil.waitForElementVisible(NPSProgram);
        //seleniumutil.click(NPSProgram);
        seleniumutil.jseClickInnerElement(NPSProgram);
        Thread.sleep(1000);
        System.out.println("3");

        //seleniumutil.waitForElementVisible(reportingIcon);
        //seleniumutil.click(menuIconsDropdown);
        //System.out.println("4");
        //seleniumutil.assertIsDisplayed(reportingIcon);
        //System.out.println("5");
    }



    public void waitForPageLoaded() {
        seleniumutil.waitForPageLoaded();
    }
}
