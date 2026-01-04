package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static File filePath;

    public void onStart(ITestContext context) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        filePath = new File(System.getProperty("user.dir")+ "/reports/extentreport_"+formatter.format(new Date())+".html");
        sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setDocumentTitle("Tutorialsninja functional testing");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Functional Testing");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

    }

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.info(result.getName() + "Test Started");
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, result.getName() + "Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        try {
            extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(Base.getScreenShotPath()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getName() + "Test skipped");

    }

    public void onFinish(ITestContext context) {
        extentTest.log(Status.INFO, "Test finished and flushing the report");
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(filePath.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
