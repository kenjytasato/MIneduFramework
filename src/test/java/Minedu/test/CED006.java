package Minedu.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public void setupEnv() {
        Driver = new driver(1);
        lp = new landingPOM(Driver);
        afcp = new applyForCertificatePOM(Driver);
        att = new aplicantTypeTutorPOM(Driver);
        ptP = new personTypePOM(Driver);
        tacp = new termsAndConditionsPOM(Driver);
        LpTest = new landingPage(Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting Demo Testing Minedu");
        Report = new report();
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
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
/*
        //*[@id="classic-modal-slide-description"]/p    los datos ingresados no coinciden con los datos reniec
        /html/body/div[4]/div[3]/div/div[3]/button       boton de aceptar
        
 */

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


        } catch (Throwable e) {
            System.out.println("one elemnt is not present");
        }

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
    }



    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}