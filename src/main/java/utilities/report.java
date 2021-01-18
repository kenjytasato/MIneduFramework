package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.codemodel.internal.JCatchBlock;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class report {

    String title = null;
    String reportName = null;
    String environment = null;
    String suite = null;
    String frameworkVer = null;
    String project = null;
    String author = null;
    String appVer = null;
    ExtentReports extent = null;

    public FileReader reader = null;
    public Properties p = null;
    ExtentTest logger = null;

    public report() {
        try {
            String prop_path = System.getProperty("user.dir") + System.getProperty("file.separator") + "env/reportConfig.properties";
            FileReader readeri = new FileReader(prop_path);
            reader = readeri;
            p = new Properties();
            p.load(reader);
        } catch (Exception e) {
            System.out.println("el archivo de configuracion de reporte se cargo de manera inadecuada");
            e.printStackTrace();
        }


        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/main/resources/Reports/omg.html");
        reporter.config().setDocumentTitle(p.getProperty("title"));
        reporter.config().setReportName(p.getProperty("reportName"));


        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("environment", p.getProperty("environment"));
        extent.setSystemInfo("suite", p.getProperty("suite"));
        extent.setSystemInfo("version del framework", p.getProperty("frameworkVer"));
        extent.setSystemInfo("proyecto", p.getProperty("project"));
        extent.setSystemInfo("autor", p.getProperty("author"));
        extent.setSystemInfo("version", p.getProperty("appVer"));


    }

    public void createTest(String testName) {
        logger = extent.createTest(testName);
    }

    public void pass(String passMsg) {
        logger.log(Status.PASS, passMsg);
    }

    public void fail(String failMsg) {
        logger.log(Status.FAIL, failMsg);
    }

    public void logInfo(String infoMsg) {
        logger.log(Status.INFO, infoMsg);
    }

    public void addScreenshot(String path) {
        //  logger.addScreenCaptureFromPath("./screenshots/"+takeScreenshot());
    }

    public void assertionErrorMsg(AssertionError e) {
        logger.fail(e.getMessage());
    }

    public void generateReport() {
        extent.flush();
    }


}
