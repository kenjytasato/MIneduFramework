package Minedu.test;

import driver.driver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.landingPage;


import java.text.ParseException;

public class CED002 {

    driver Driver = null;


    @BeforeClass
    public void setupEnv(ITestContext context) {
        Driver = new driver(1);
        context.setAttribute("Driver", Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting CED002 tests");

    }

    @Test(priority = 2, testName = "CED002 - // Quiero ingresar a la opción 'Solicitar Constancia'")
    public void CED002_quiero_ingresar_opcion_solicitar_constancia() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPage LpTest = new landingPage(Driver);

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

    @Test(priority = 2, testName = "CED002_1 - revisar elementos en landing page")
    public void CED002_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPage LpTest = new landingPage(Driver);


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
    public void afterMethod(ITestResult result) {

    }

    @AfterClass
    public void teardown() {

        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}