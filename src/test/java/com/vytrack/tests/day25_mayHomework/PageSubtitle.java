package com.vytrack.tests.day25_mayHomework;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitle extends TestBase {
    @Test
    public void pageSubtitleTest(){
        extentLogger=report.createTest("Page SubtitleName Verification");

        extentLogger.info("Username: "+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: "+ConfigurationReader.get("storemanager_password"));
        new LoginPage().loginAsDriver();
        BrowserUtils.waitFor(5);

        extentLogger.info("Navigate Activities--Calendar Events");
        navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        extentLogger.info("Verification Name: "+calendarEventsPage.calendarPageSubtitle.getText());
        Assert.assertTrue(calendarEventsPage.calendarPageSubtitle.isDisplayed(),"verify is Ok");




    }
    @Test
    public void pageNumberTest(){
        extentLogger=report.createTest("Page Number Verification");

        extentLogger.info("Username: "+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: "+ConfigurationReader.get("storemanager_password"));
        new LoginPage().loginAsDriver();
        BrowserUtils.waitFor(5);

        extentLogger.info("Navigate Activities--Calendar Events");
        navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.pageNumber.getAttribute("value");
        extentLogger.info("Page Number: "+calendarEventsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1");
    }
   @Test
    public void viewPerPageTest(){
       extentLogger=report.createTest("View Per Page Number Verification");

       extentLogger.info("Username: "+ ConfigurationReader.get("storemanager_username"));
       extentLogger.info("Password: "+ConfigurationReader.get("storemanager_password"));
       new LoginPage().loginAsDriver();
       BrowserUtils.waitFor(5);

       extentLogger.info("Navigate Activities--Calendar Events");
       navigateToModule("Activities","Calendar Events");

       CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
       BrowserUtils.waitFor(5);
       extentLogger.info("View Per Page Number: "+calendarEventsPage.viewPerPage.getAttribute("data-size"));
       Assert.assertEquals(calendarEventsPage.viewPerPage.getAttribute("data-size"),"25");
   }
}
