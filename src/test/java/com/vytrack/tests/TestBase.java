package com.vytrack.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.pages.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase extends BasePage {
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentTest extentLogger;

  @BeforeTest
    public void setUp(){
      report= new ExtentReports();
      String projectPath=System.getProperty("user.dir");
      String path=projectPath+"/test-output/report.html";
      htmlReporter=new ExtentHtmlReporter(path);
      report.attachReporter(htmlReporter);
      htmlReporter.config().setReportName("Vytrack Smoke Test");
      report.setSystemInfo("Environment","QA");
      report.setSystemInfo("Browser","Chrome");
      report.setSystemInfo("Tester","Cybertek Testers");
      report.setSystemInfo("OS",System.getProperty("os.name"));
  }
  @BeforeMethod
    public void setUpMethod(){
      driver= Driver.get();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      actions=new Actions(driver);
      wait=new WebDriverWait(driver,10);
      driver.get(ConfigurationReader.get("url"));

  }
  @AfterMethod
    public void afterMethod(ITestResult result) throws IOException, InterruptedException {
      if(result.getStatus()==ITestResult.FAILURE){
          extentLogger.fail(result.getName());
          String screenshot= BrowserUtils.getScreenshot(result.getName());
          extentLogger.addScreenCaptureFromPath(screenshot);
          extentLogger.fail(result.getThrowable());

      }
      Thread.sleep(3000);
      Driver.closeDriver();
  }
  @AfterTest
  public void tearDownTest(){
      report.flush();
  }
}
