package com.inmoment.reporting.common;

import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeSuite
    public void beforeSuite(){
        Driver.setUpDriver();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
