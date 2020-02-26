package com.inmoment.reporting.tests;

import com.inmoment.reporting.common.Driver;
import com.inmoment.reporting.common.TestBase;
import com.inmoment.reporting.pages.LoginPage;
import com.inmoment.reporting.utils.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    WebDriver driver;
    SeleniumUtil seleniumUtil = new SeleniumUtil();
    LoginPage loginPage = new LoginPage();

    @Test (priority = 0)
    public void verifyLoginSuccessfully() throws InterruptedException {
        loginPage.loginSuccessfully(seleniumUtil.getProperty("loginEmailJoe"), seleniumUtil.getProperty("loginPasswordJoe"));

    }

    @Test (priority = 1)
    public void verifyGoNPSProgram() throws InterruptedException {
        loginPage.goToNPSProgram();
    }


}
