package Minedu.test;

import driver.driver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.landingPage;
import pom.applyForCertificatePOM;
import pom.landingPOM;
import java.text.ParseException;


public class CED003 {

    driver Driver = null;


    @BeforeClass
    public void setupEnv(ITestContext context) {
        Driver = new driver(1);
        context.setAttribute("Driver", Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting CED003 tests");

    }


    @Test(priority = 2, testName = ("CED003 - Quiero aceptar los terminos y condiciones")) //ok funcionando
    public void CED003_1() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();

        Assert.assertEquals(afcp.checkCertificate(), true);
        Assert.assertEquals(afcp.checkTabDescription(), "BÚSQUEDA INSTITUCIÓN");

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
        Assert.assertEquals(LpTest.checkElementsMineduLogo(), true);
        Assert.assertEquals(LpTest.checkElementsCertificadoEstudiosTitle(), true);
        Assert.assertEquals(LpTest.checkElementsInformativeText(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateBtn(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateImage(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateText(), true);
        Assert.assertEquals(LpTest.checkElementssemiFooterBody(), true);
        Assert.assertEquals(LpTest.checkElementssemiFooterTitle(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateBtn(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateImage(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateText(), true);
    }

    @AfterMethod


    @AfterClass
    public void teardown() {

        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}