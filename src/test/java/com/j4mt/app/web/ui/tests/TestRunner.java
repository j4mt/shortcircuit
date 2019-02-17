
package com.j4mt.app.web.ui.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.j4mt.app.web.ui.tests.driver.DriverProvider;
import com.j4mt.app.web.ui.tests.helpers.ReportHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/** Tag Details
 * Smoke Test - @SmokeTest
 **/

@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/features", glue = "com.j4mt.app.web.ui.tests.steps", format = {"pretty","json:target/cucumber.json"}, tags = { " @googlsearch" })
public class TestRunner extends AbstractTestNGCucumberTests {

//    WebDriver driver;



//    @AfterClass(alwaysRun = true)
//    public void takeScreenshot() throws Exception {
//        File scrFile = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
//        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
//        trgtFile.getParentFile().mkdir();
//        trgtFile.createNewFile();
//        java.nio.file.Files.copy(scrFile, trgtFile, CopyOption);
//
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDownr(ITestResult result) throws Exception {
//        if (result.isSuccess()) {
//            File imageFile = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
//            String failureImageFileName = result.getMethod().getMethodName()
//                    + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
//            File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
//            failureImageFile.getParentFile().mkdir();
//            failureImageFile.createNewFile();
//            CopyOption[] options = new CopyOption[] {StandardCopyOption.REPLACE_EXISTING};
//            //Files.copy(imageFile,failureImageFile);
//        }
//
//    }
//    @AfterSuite(alwaysRun=true)
//    public void generateHTMLReports() {
//        System.out.println(DriverProvider.getCurrentDriver());
//        ReportHelper.generateCucumberReport();
//    }

    @AfterSuite(alwaysRun = true)
    public void quit() throws IOException, InterruptedException {
        DriverProvider.getCurrentDriver().quit();
    }
}
