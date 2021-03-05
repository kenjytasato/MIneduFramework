package Minedu.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.landingPage;
import pom.aplicantTypeStudientPOM;
import pom.applyForCertificatePOM;
import pom.landingPOM;
import pom.personTypePOM;
import utilities.report;

import java.text.ParseException;

public class CED002 {

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

    @Test(priority = 2, testName = ("CED002 - // Quiero ingresar a la opción 'Solicitar Constancia'"))
    public void CED002() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe");
        //Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPage LpTest = new landingPage(Driver);

        try {
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
          //  Assert.assertEquals(LpTest.checkElementssingleCertificateText(), "3");
            System.out.println("todos los elementos son visibles");
            Report.createTest("pass test: CED002 - // Quiero ingresar a la opción 'Solicitar Constancia'");
            Report.pass("se puede ingresar a la opcion 'solicitar constancia'" );


        } catch (Throwable e) {
            System.out.println("one or more element is not present");
            Report.createTest("one or more element is not present: CED002 - // Quiero ingresar a la opción 'Solicitar Constancia'");
            Report.fail("fallo el test" + e);
          }
    }

    @Test(priority = 2, testName = ("CED002_1 - revisar elementos en landing page"))
    public void CED002_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPage LpTest = new landingPage(Driver);

        try {
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
            System.out.println("todos los elementos son visibles");
            Report.createTest("pass test: CED002 -  revisar elementos en landing page");
            Report.pass("todos los elementos son visibles" );

        } catch (Throwable e) {

            Report.createTest("one or more element is not present: CED002_1 - /revisar elementos en landing page");
            Report.fail("fallo el test" + e);
        }
    }

    @AfterClass
    public void teardown() {
        Report.generateReport();
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}