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
import pom.aplicantTypeStudientPOM;
import pom.applyForCertificatePOM;
import pom.landingPOM;
import pom.personTypePOM;
import utilities.report;

import java.text.ParseException;

public class CED011 {
//Quiero ingresar a la opción "Validar Constancia"
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

        System.out.println("Starting Demo Testing Minedu");
        Report = new report();
    }

/*
    @Test(priority = 2, testName = ("CED002 - // Quiero ingresar a la opción 'Solicitar Constancia'"))
    public void CED002() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPage LpTest = new landingPage(Driver);


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



    }

    @Test(priority = 2, testName = ("CED003 - Quiero aceptar los terminos y condiciones"))
    public void CED003_1() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();

        Assert.assertEquals(afcp.checkCertificate(), true);
        Assert.assertEquals(afcp.checkTabDescription(), "BÚSQUEDA INSTITUCIÓN");
         }



    @Test(priority = 2, testName = ("CED011_1 - Interesado ingresa a la opción 'Validar Constancia' mediante la Web Responsive."))
    public void CED011_1() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);
        aplicantTypeStudientPOM atd = new aplicantTypeStudientPOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        //añadir acerto que si nohayt nada
    }

    @Test(priority = 2, testName = ("CED011_2 - Interesado ingresa a la opción 'Validar Constancia' mediante la lectura del código QR"))
    public void CED011_2() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);
        aplicantTypeStudientPOM atd = new aplicantTypeStudientPOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        //añadir acerto que si nohayt nada
    }











    /*
    @Test(priority = 2, testName = ("CED004_2 - Quiero ingresar a una opcion tipo de usuario-tutor"))
    public void CED004_2() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        landingPage LpTest = new landingPage(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectTutor();
        ptP.doNothingWaitForAlert();
    }
*/



    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}