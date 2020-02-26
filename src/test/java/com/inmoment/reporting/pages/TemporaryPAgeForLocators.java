package com.inmoment.reporting.pages;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.PageBase;
import com.inmoment.reporting.utils.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TemporaryPAgeForLocators extends PageBase {
    public static WebDriver driver = Driver.getDriver();
    public static LoginPage loginPage = new LoginPage();
    public static ReportingPage reportingPage = new ReportingPage();
    public static By iFrame = By.cssSelector("div.dashboard-holder>iframe");
    public static SeleniumUtil seleniumutil = new SeleniumUtil();
    public static By emailDispositonPageElements = By.xpath("//div[@class='dashboard-element ng-isolate-scope']/..");
    public static By ahrefNumbersPageElements = By.xpath("//a[@href='#drillmenu']");
    public static By contextTitleTextElements = By.xpath("//span[@class='looker-vis-context-title-text '] ");
    public static boolean enabled;
    public static void main(String[] args) throws InterruptedException {
        reportingPage.goToReportingPage();
        //int size = driver.findElements(By.tagName("iframe")).size();
        //System.out.println(size);
        seleniumutil.waitForElementVisible(iFrame);
        driver.switchTo().frame(driver.findElement(iFrame));
       /* List<WebElement> emailPageElements;
        emailPageElements = seleniumutil.findElements(emailDispositonPageElements);
        for (WebElement element: emailPageElements
        ) {
            seleniumutil.getText(element);
            System.out.println("Text: " + element);
            seleniumutil.getAttribute(element);
            System.out.println("Attribute value: " + element);
        } */

        //List<WebElement> pageRates = seleniumutil.findElements(ahrefNumbersPageElements);
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //trying to return the inner text but does not work
       // for(WebElement element: pageRates){
            //element.getText();
           // System.out.println("Inner Text: " + element);

           // element.getAttribute("textContent");
            //System.out.println("textContent: " + element);
            

       // }

        List<WebElement> titleContexts = seleniumutil.findElements(contextTitleTextElements);
        for (WebElement element: titleContexts
             ) {
            //element.getLocation();
            //System.out.println("location: " + element);
            //element.getText();
           // System.out.println("text: " + element);
            enabled = element.isEnabled();
            Assert.assertTrue(enabled);
        }


    }

}
