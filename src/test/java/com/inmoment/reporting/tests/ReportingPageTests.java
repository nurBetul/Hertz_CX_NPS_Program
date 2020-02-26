package com.inmoment.reporting.tests;

import com.inmoment.reporting.common.TestBase;
import com.inmoment.reporting.pages.ReportingPage;
import org.testng.annotations.Test;

public class ReportingPageTests extends TestBase {
    ReportingPage reportingPage = new ReportingPage();
    @Test
    public void verifyGoToReportingPage() throws InterruptedException {
       reportingPage.goToReportingPage();

    }
    @Test
    public void verifyIfEmailDispositionElementsAreDisplayed() throws InterruptedException {
        reportingPage.controlEmailDispositionElementsAreVisible();
    }
    @Test
    public void verifyGoToProgramOverview() throws InterruptedException {
        reportingPage.goProgramOverview();
    }
    @Test
    public void verifyIfProgramOverviewElementsAreDisplayed() throws InterruptedException {
        reportingPage.controlProgramOverviewElementsAreVisible();
    }

}
