package com.inmoment.reporting.common;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeSuite
    public void beforeSuite(){
        Driver.setUpDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   /*@BeforeClass
    public void beforeClass(){
        Driver.setUpDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void  afterClass(){
        Driver.closeDriver();
    } */

    @AfterSuite
    public void afterSuite(){
        Driver.closeDriver();
    }
}
