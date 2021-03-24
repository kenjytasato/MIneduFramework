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

public class CED004 {

    driver Driver = null;
    WebElement we = null;
    report Report = null;

    @BeforeClass
    public void setupEnv(ITestContext context) {
        Driver = new driver(1);
        context.setAttribute("Driver", Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting CED004 tests");

    }

    @Test(priority = 2, testName = ("CED004_1 - Quiero ingresar a una opcion tipo de usuario-personal"))
    public void CED004_1() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");

        termsAndConditionsPOM tacp = new termsAndConditionsPOM(Driver);
        tacp.acceptTerms();
        aplicantTypeStudientPOM atd = new aplicantTypeStudientPOM(Driver);

        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        Assert.assertEquals(atd.checkElements(), true);



    }

    @Test(priority = 2, testName = ("CED004_2 - Quiero ingresar a una opcion tipo de usuario-tutor"))
    public void CED004_2() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department", "province", "district", "modularCode");
        termsAndConditionsPOM tacp = new termsAndConditionsPOM(Driver);
        tacp.acceptTerms();
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectTutor();
        aplicantTypeTutorPOM att = new aplicantTypeTutorPOM(Driver);

        Assert.assertEquals(att.checkElements(), true);

    }

    @Test(priority = 2, testName = ("CED004_3 - El interesado no continúa con el proceso."))
    public void CED004_3() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department", "province", "district", "modularCode");
        termsAndConditionsPOM tacp = new termsAndConditionsPOM(Driver);
        tacp.cancel();

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

    @Test(priority = 2, testName = ("CED004_4 - El interesado no desea continuar con el proceso."))
    public void CED004_4() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department", "province", "district", "modularCode");
        termsAndConditionsPOM tacp = new termsAndConditionsPOM(Driver);
        tacp.cancelandcontinue();


            Assert.assertEquals(tacp.checktitle(), true );


    }


    @Test(priority = 2, testName = ("CED004_5 - Interesado no realiza ni una accion."))
    public void CED004_5() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department", "province", "district", "modularCode");
        termsAndConditionsPOM tacp = new termsAndConditionsPOM(Driver);
        tacp.acceptTerms();
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.doNothingWaitForAlert();
        Assert.assertEquals(ptP.checkdoNothingButton(), true );
    }

    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}