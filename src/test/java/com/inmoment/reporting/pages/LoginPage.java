package com.inmoment.reporting.pages;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends PageBase {
    private  WebDriver driver = Driver.getDriver();
    private  By emailLocator = By.cssSelector("input#mat-input-0");
    private  By passwordLocator = By.cssSelector("input#mat-input-1");
    private  By loginButtonLocator = By.cssSelector("div[class=button-text]");
    private  By hertzCXLocator = By.cssSelector("div[class=account-program-wrapper]");
    private By headingMessage = By.xpath("//div[@class='super-heading-message']");
    private  By userDropDown = By.xpath("//div[normalize-space(@class)='arrow-wrapper ng-tns-c15-4 ng-star-inserted']");
    private  By NPSProgram = By.xpath("//div[@class='link-wrapper']//descendant::div[text()='Hertz - NPS Program']");
    private By menuIconsDropdown = By.cssSelector("div#3a7b08cb-f54b-4700-8057-037f7728273d");
    private By reportingIcon = By.xpath("//li[normalize-space(@class)='basic-tile-wrapper ng-tns-c12-15 ng-star-inserted']//div[@class='tile-text-container']//child::div[text()=' Reporting ']");



    public void loginSuccessfully (String username, String password) throws InterruptedException {
        seleniumutil.goToPage(seleniumutil.getProperty("reportingPageUrl"));
        waitForPageLoaded();
        seleniumutil.implicitlyWait(5);
        seleniumutil.click(emailLocator);
        seleniumutil.sendKEys(emailLocator, username);
        seleniumutil.click(passwordLocator);
        seleniumutil.sendKEys(passwordLocator , password);
        seleniumutil.click(loginButtonLocator);
        waitForPageLoaded();
        System.out.println(driver.getCurrentUrl());
        //seleniumutil.waitForElementVisible(hertzCXLocator);
        //seleniumutil.assertIsDisplayed(hertzCXLocator);
        seleniumutil.deleteCookies();
    }
    public void loginSuccessfully() throws InterruptedException {
        seleniumutil.goToPage(seleniumutil.getProperty("reportingPageUrl"));
        waitForPageLoaded();
        seleniumutil.implicitlyWait(5);
        seleniumutil.click(emailLocator);
        seleniumutil.sendKEys(emailLocator, seleniumutil.getProperty("loginEmailJoe"));
        seleniumutil.click(passwordLocator);
        seleniumutil.sendKEys(passwordLocator , seleniumutil.getProperty("loginPasswordJoe"));
        seleniumutil.click(loginButtonLocator);
        waitForPageLoaded();
        System.out.println(driver.getCurrentUrl());
        //seleniumutil.waitForElementVisible(hertzCXLocator);
        //seleniumutil.assertIsDisplayed(hertzCXLocator);
        seleniumutil.deleteCookies();
    }
    public void goToNPSProgram() throws InterruptedException {
        loginSuccessfully();
        System.out.println("1");
        seleniumutil.getThread(1000);
        seleniumutil.click(userDropDown);
        System.out.println("2");
        seleniumutil.getThread(1000);
        seleniumutil.click(NPSProgram);
        System.out.println("3");
        seleniumutil.getThread(1000);
        seleniumutil.click(menuIconsDropdown);
        System.out.println("4");
        seleniumutil.getThread(1000);
        seleniumutil.assertIsDisplayed(reportingIcon);
        System.out.println("5");
    }



    public void waitForPageLoaded() {
        seleniumutil.waitForPageLoaded();
    }
}
