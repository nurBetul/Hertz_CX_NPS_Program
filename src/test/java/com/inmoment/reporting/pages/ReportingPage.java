package com.inmoment.reporting.pages;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

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
    private By emailDispositonPageElements = By.xpath("//div[@class='dashboard-element ng-isolate-scope']/..");
    private By iFrame = By.cssSelector("div.dashboard-holder>iframe");
    private By poiFrame = By.xpath("//iframe[@title='Latest Month']");
    private By programOverviewElements = By.xpath("//div[@class='vis-header-note-and-wrapper']");

    public void goToReportingPage() throws InterruptedException {
        //loginPage.goToNPSProgram();
        seleniumutil.jseClickInnerElement(menuIconsDropdown);
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        seleniumutil.jseClickInnerElement(reportingIcon);
        System.out.println("4");
        Set<String> winHandles = driver.getWindowHandles();
        for (String handle: winHandles
             ) {
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
            }
        }
        Reporter.log("Clicked reporting icon and switched to the reporting page");
    }

    public void controlEmailDispositionElementsAreVisible() throws InterruptedException {
        //goToReportingPage();
        seleniumutil.waitForElementVisible(iFrame);
        driver.switchTo().frame(driver.findElement(iFrame));
        List<WebElement> emailPageElements;
        emailPageElements = seleniumutil.findElements(emailDispositonPageElements);
        for (WebElement element: emailPageElements
             ) {
            seleniumutil.assertIsDisplayed(element);
            System.out.println(element.getText());
        }

        Reporter.log("Controlled 18 elements are displayed in email disposition");
    }


    public void goProgramOverview() throws InterruptedException {
        goToReportingPage();
        seleniumutil.waitForElementVisible(emailDisposition);
        seleniumutil.click(emailDisposition);
        seleniumutil.click(programOverview);
        String url = seleniumutil.getCurrentUrl();
        System.out.println(url);

        Reporter.log("Clicked program overview and went to the page.");
    }

    public void controlProgramOverviewElementsAreVisible() throws InterruptedException {
        goProgramOverview();
        seleniumutil.waitForElementVisible(poiFrame);
        driver.switchTo().frame(driver.findElement(poiFrame));
        List<WebElement> poElements = seleniumutil.findElements(programOverviewElements);
        for (WebElement element: poElements
             ) {
            seleniumutil.assertIsDisplayed(element);
            System.out.println(element.getText());
        }

        Reporter.log("Controlled if the elements in the Program Overview page are displayed.");

    }





}
