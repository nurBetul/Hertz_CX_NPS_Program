package com.inmoment.reporting.tests;

import com.inmoment.reporting.common.TestBase;
import com.inmoment.reporting.pages.ReportingPage;
import org.testng.annotations.Test;

public class ReportingPageTests extends TestBase {
    ReportingPage reportingPage = new ReportingPage();
    @Test (priority = 2)
    public void verifyGoToReportingPage() throws InterruptedException {
       reportingPage.goToReportingPage();

    }
    @Test (priority = 3)
    public void verifyIfEmailDispositionElementsAreDisplayed() throws InterruptedException {
        reportingPage.controlEmailDispositionElementsAreVisible();
    }
    @Test (priority = 4)
    public void verifyGoToProgramOverview() throws InterruptedException {
        reportingPage.goProgramOverview();
    }
    @Test (priority = 5)
    public void verifyIfProgramOverviewElementsAreDisplayed() throws InterruptedException {
        reportingPage.controlProgramOverviewElementsAreVisible();
    }

}
