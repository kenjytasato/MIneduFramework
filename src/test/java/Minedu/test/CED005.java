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

public class CED005 {

    //Quiero ingresar mis datos personales como usuario interesado para validarlo con el servicio de RENIEC
    driver Driver = null;
    WebElement we = null;
    report Report = null;
    Boolean b = true;
    landingPOM lp = null;
    landingPage LpTest = null;
    applyForCertificatePOM afcp = null;
    aplicantTypeStudientPOM atd = null;
    personTypePOM ptP = null;
    termsAndConditionsPOM tacp = null;

    @BeforeClass

    public void setupEnv(ITestContext context) {
        Driver = new driver(1);
         context.setAttribute("Driver", Driver);
        lp = new landingPOM(Driver);
        LpTest = new landingPage(Driver);
        afcp = new applyForCertificatePOM(Driver);
        atd = new aplicantTypeStudientPOM(Driver);
        ptP = new personTypePOM(Driver);
        tacp = new termsAndConditionsPOM(Driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Starting CED005 tests");

    }

    @Test(priority = 2, testName = ("CED005_1 - Interesado ingresa todos los campos obligatorios ->datos no validos"))//ok
    public void CED005_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("nombre del padre","nombre de la madre","2001","dic","25",12345678,"department1","province1","district1");
        atd.pressAccept();
        Assert.assertEquals(atd.checkElements(), true);
    }

    @Test(priority = 2, testName = ("CED005_2 - Interesado no ingresa todos los campos obligatorios correctamente."))
    public void CED005_2() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",12345678,"department1","province1","district1");

        atd.pressAccept();
        Assert.assertEquals(atd.checkElements(), true);
    }
    @Test(priority = 2, testName = ("CED005_3 - Interesado ingresa todos los campos obligatorios válidos"))
    public void CED005_3() throws InterruptedException, ParseException {

         Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344,"department1","province1","district1");

        Assert.assertEquals(atd.checkElements(), true);

    }
    @Test(priority = 2, testName = ("CED005_4 - El interesado no continúa con el proceso."))
    public void CED005_4() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344,"department1","province1","district1");
        atd.pressCancel();
        Assert.assertEquals(atd.checkCancelText() , b);


    }

    @Test(priority = 2, testName = ("CED005_5 - El interesado no desea continuar con el proceso."))
    public void CED005_5() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344,"department1","province1","district1");

        atd.pressCancel();
        Driver.implicitwait();
        atd.pressConfirmAccept();


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


    @Test(priority = 2, testName = ("CED005_7 - Interesado no realiza ni una accion."))
    public void CED005_7() throws InterruptedException, ParseException {


        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344,"department1","province1","district1");

        ptP.doNothingWaitForAlert();
        Assert.assertEquals(ptP.checkdoNothingButton(), true );

    }

    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}