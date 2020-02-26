package com.inmoment.reporting.utils;

import com.inmoment.reporting.common.Driver;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumUtil {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Actions act = new Actions(Driver.getDriver());

    public void goToPage(String url){
        driver.get(url);
    }
    public void getThread(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }
    public String getProperty(String key){
        return Driver.getProp(key);
    }

    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").
                        toString().equals("complete");
            }
        };
        try {
            getThread(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error){
            Assert.fail("Timeout waiting for Page Load Request to complete");
        }
    }

    public WebElement findElement (By locator){
        return driver.findElement(locator);
    }
    public void sendKEys(By locator, String text){
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }
    public void click (By locator){
        findElement(locator).click();
    }

    public void clear (By locator){ findElement(locator).clear(); }

    public void clickEnterKey (By locator){
        findElement(locator).sendKeys(Keys.ENTER);
    }

    public void assertIsDisplayed(By locator){
        Assert.assertTrue(findElement(locator).isDisplayed());
    }

    public void assertIsDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public void waitForElementVisible(WebElement element){ wait.until(ExpectedConditions.visibilityOf(element)); }
    public void waitForElementVisible(By locator){ wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
    public void waitForInvisibilityOfElement(By locator){ wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));}

    public void deleteCookies(){ driver.manage().deleteAllCookies(); }
    public void fluentlyWait(){
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(60,TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }
    public void jseClickInnerElement(By locator){
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }
    public List<WebElement> findElements(By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }
    public void getText (By locator){
        driver.findElement(locator).getText();
    }
    public void getText (WebElement element){
        element.getText();
    }
    public void getAttribute(WebElement element){
        element.getAttribute("value");
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
