package Minedu.test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.landingPage;
import pom.aplicantTypeStudientPOM;
import pom.applyForCertificatePOM;
import pom.landingPOM;
import pom.personTypePOM;
import utilities.report;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.text.ParseException;

public class CED003 {

    driver Driver = null;
    WebElement we = null;
    report Report = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver(1);
        Report = new report();
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting Demo Testing Minedu");

    }


    @Test(priority = 2, testName = ("CED003 - Quiero aceptar los terminos y condiciones")) //ok funcionando
    public void CED003_1() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        try {
        Assert.assertEquals(afcp.checkCertificate(), true);
        Assert.assertEquals(afcp.checkTabDescription(), "BÚSQUEDA INSTITUCIÓN");
        Report.createTest("CED003 - Quiero aceptar los terminos y condiciones");
        Report.pass("todos los elementos son visibles" );
    } catch (Throwable e) {
            Report.createTest("CED003 - Quiero aceptar los terminos y condiciones");
            Report.fail("fallo el test" + e);
        }
         }

    @Test(priority = 2, testName = ("CED003 -No Quiero aceptar los terminos y condiciones")) //ok funciona
    public void CED003_2() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);
        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.cancelTerms();

        Assert.assertEquals(afcp.checkCertificate(), true);
        Assert.assertEquals(LpTest.checkElementsMineduLogo(), true );
        Assert.assertEquals(LpTest.checkElementsCertificadoEstudiosTitle() , true );
        Assert.assertEquals(LpTest.checkElementsInformativeText() , true );
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateBtn() , true );
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateImage() , true );
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateText() , true );
        Assert.assertEquals(LpTest.checkElementssemiFooterBody() , true );
        Assert.assertEquals(LpTest.checkElementssemiFooterTitle() , true );
        Assert.assertEquals(LpTest.checkElementssingleCertificateBtn() , true );
        Assert.assertEquals(LpTest.checkElementssingleCertificateImage() , true );
        Assert.assertEquals(LpTest.checkElementssingleCertificateText() , true );
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){

            Report.fail(" - Test Case Failed");
        }else if(result.getStatus() == ITestResult.SKIP){

            Report.skip("rest skip");
        }
    }


    @AfterClass
    public void teardown() {
        Report.generateReport();
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}