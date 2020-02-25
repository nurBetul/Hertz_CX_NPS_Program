package com.inmoment.reporting.pages;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class ReportingPage extends PageBase {

    LoginPage loginPage = new LoginPage();
    private WebDriver driver = Driver.getDriver();
    private By menuIconsDropdown = By.xpath("//div[@class='sc-jlyJG ekQpXr']");
    private By reportingIcon = By.xpath("//li[@class='basic-tile-wrapper ng-tns-c12-11 ng-star-inserted']/div[@class='tile-text-container']/div[contains(text(),' Reporting ')]");
    private By emailDisposition = By.xpath("//div[@class='sc-iyvyFf lgPhRs']");
    private By programOverview = By.xpath("//p[contains(text(),'Program Overview')]");
    private By filters = By.xpath("//strong[@class='filter-section-title']");
    private By allElementNearFilters = By.xpath("//span[@class='ng-binding ng-scope']//..");
    private By keyMeasuresFiveElements = By.xpath("//div[@class='vis-single-value-no-results']");
    //private By emailDispositonPageElements = By.xpath("//div[@class='vis-wrapper-container']");
    private By emailDispositonPageElements = By.xpath("//div[@class='dashboard-element ng-isolate-scope']/..");

    public void goToReportingPage() throws InterruptedException {
        loginPage.goToNPSProgram();
        seleniumutil.jseClickInnerElement(menuIconsDropdown);
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        seleniumutil.jseClickInnerElement(reportingIcon);
        Set<String> winHandles = driver.getWindowHandles();
        for (String handle: winHandles
             ) {
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
            }
        }
    }

    public void controlEmailDispositionElementsAreVisible() throws InterruptedException {
        goToReportingPage();
        //seleniumutil.waitForElementVisible(emailDispositonPageElements);
        List<WebElement> emailPageElements;
        emailPageElements = seleniumutil.findElements(emailDispositonPageElements);
        for (WebElement element: emailPageElements
             ) {
            seleniumutil.getText(element);
            System.out.println("Text: " + element);
            seleniumutil.getAttribute(element);
            System.out.println("Attribute value: " + element);
        }
    }



    public void goProgramOverview() throws InterruptedException {
        goToReportingPage();
        seleniumutil.waitForElementVisible(emailDisposition);
        seleniumutil.click(emailDisposition);
        seleniumutil.click(programOverview);


    }





}
