package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.report;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;
import java.sql.Timestamp;
import driver.driver;

public class TestListeners implements ITestListener {



   ExtentReports extent = null;
    public FileReader reader = null;
    public Properties p = null;
    ExtentTest logger = null;



    @Override
    public void onTestStart(ITestResult result) {

        ExtentManager extManager = new ExtentManager();
        this.extent = extManager.getReporter();
        logger = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String logText = "<b>Test Method"+ result.getMethod().getMethodName() + "Successful</b>";
        Markup m = MarkupHelper.createLabel(logText , ExtentColor.GREEN);
      //  logger = extent.createTest("hola");
     //   logger = extent.createTest(result.getTestName());
        logger.log(Status.PASS, m);


    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {


        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

        ITestContext context = result.getTestContext();
       // WebDriver driver = (WebDriver)context.getAttribute("Driver");

        driver Driver = (driver) context.getAttribute("Driver");



        logger = extent.createTest(methodName);
        //logger = extent.createTest(result.getTestName());
        logger.fail("<details><summary><b><font color=red>"+
                "Exception Occured, click to see details:" + "</font></b></summary>"+
                exceptionMessage.replaceAll(",","<br>")+"</details> /n");

   String path = Driver.takeScreenshot(result.getMethod().getMethodName());
        try
        {
            logger.fail("<b><font color=red>"+"Sreenshot of failure"+"</font></b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        catch(IOException e)
        {
            logger.fail("Test Failed, cannot attach screenshot");
        }

        String logText = "<b>Test Method"+ result.getMethod().getMethodName() + "Fail</b>";
        Markup m = MarkupHelper.createLabel(logText , ExtentColor.RED);
       logger.log(Status.FAIL, m);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method"+ result.getMethod().getMethodName() + "Skipped</b>";
        Markup m = MarkupHelper.createLabel(logText , ExtentColor.YELLOW);
        logger.log(Status.SKIP, m);

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        if (extent != null)
        {
            extent.flush();
        }

    }


}
