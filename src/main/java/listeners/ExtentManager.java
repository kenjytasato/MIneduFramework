package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class ExtentManager {


    public static ExtentReports extent;

    public ExtentReports getReporter() {
        Properties p = null;
        if (extent == null) {
            try {
                String prop_path = System.getProperty("user.dir") + System.getProperty("file.separator") + "env/reportConfig.properties";
                FileReader readeri = new FileReader(prop_path);
                p = new Properties();
                p.load(readeri);
            } catch (Exception e) {
                System.out.println("el archivo de configuracion de reporte se cargo de manera inadecuada");
                e.printStackTrace();
            }


            ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/main/resources/Reports/" + dtimestamp() +".html");
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
        return extent;
    }
    public static String dtimestamp()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        return timestamp.toString();
    }
}
