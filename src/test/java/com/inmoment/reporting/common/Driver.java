package com.inmoment.reporting.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class Driver {
   private static WebDriver driver;
   public static WebDriver getDriver(){
        if (driver == null){
            setUpDriver();
        }
        return driver;
    }

    public static void setUpDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public static String getProp (String input){
        try{
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/java/com/inmoment/reporting/common/global.properties");
            prop.load(fis);
            return prop.getProperty(input);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
