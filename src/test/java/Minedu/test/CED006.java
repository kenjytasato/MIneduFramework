package Minedu.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.landingPage;
import pom.*;
import utilities.report;

import java.text.ParseException;

public class CED006 {

    driver Driver = null;
    WebElement we = null;
    report Report = null;
    landingPOM lp = null;
    applyForCertificatePOM afcp = null;
    aplicantTypeTutorPOM att = null;
    personTypePOM ptP = null;
    termsAndConditionsPOM tacp = null;
    landingPage LpTest = null;


    @BeforeClass
    public void setupEnv(ITestContext context) {
        Driver = new driver(1);
        context.setAttribute("Driver", Driver);
        lp = new landingPOM(Driver);
        afcp = new applyForCertificatePOM(Driver);
        att = new aplicantTypeTutorPOM(Driver);
        ptP = new personTypePOM(Driver);
        tacp = new termsAndConditionsPOM(Driver);
        LpTest = new landingPage(Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting CED006 tests");

    }

    @Test(priority = 1, testName = ("CED006_1 - Interesado 'Apoderado' ingresa todos los campos obligatorios válidos."))
    public void CED006_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        Driver.returnDriver().manage().window().maximize();
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectTutor();
        att.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);


        Assert.assertEquals(att.checkElements(), true);
    }




    @Test(priority = 2, testName = ("Interesado 'Apoderado' no continúa con el proceso."))
    public void CED006_4() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectTutor();


        att.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        Assert.assertEquals(LpTest.checkElementsInformativeText() , true );
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateBtn() , true );
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateImage() , true );
    }

    @Test(priority = 3, testName = ("Interesado 'Apoderado' no desea continuar con el proceso."))
    public void CED006_5() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectTutor();
        att.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        att.pressCancel();
        att.pressConfirmAccept();

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

    @Test(priority = 4, testName = ("Interesado 'Apoderado' no realiza ni una accion."))
    public void CED006_6() throws InterruptedException, ParseException {


        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectTutor();
        att.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        ptP.doNothingWaitForAlert();
        Assert.assertEquals(ptP.checkdoNothingButton(), true );

    }



    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}