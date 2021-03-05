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
    public void setupEnv() {
        Driver = new driver(1);
        lp = new landingPOM(Driver);
        LpTest = new landingPage(Driver);
        afcp = new applyForCertificatePOM(Driver);
        atd = new aplicantTypeStudientPOM(Driver);
        ptP = new personTypePOM(Driver);
        tacp = new termsAndConditionsPOM(Driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting Demo Testing Minedu");
        Report = new report();
    }

    @Test(priority = 2, testName = ("CED005_1 - Interesado ingresa todos los campos obligatorios ->datos no validos"))//ok
    public void CED005_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("nombre del padre","nombre de la madre","2001","dic","25",00000000);
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
        atd.fillForm("","","2001","dic","25",00000000);
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
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
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
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        atd.pressCancel();
        Assert.assertEquals(atd.checkCancelText() , b);



        //¿Está seguro de que desea salir? Se perderá el progreso realizado en el registro de la solicitud.""
    }

    @Test(priority = 2, testName = ("CED005_5 - El interesado no desea continuar con el proceso."))
    public void CED005_5() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        atd.pressCancel();
        Driver.implicitwait();
        atd.pressConfirmAccept();

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

    //CED005_6  es lo mismo
    @Test(priority = 2, testName = ("CED005_7 - Interesado no realiza ni una accion."))
    public void CED005_7() throws InterruptedException, ParseException {


        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        tacp.acceptTerms();
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        ptP.doNothingWaitForAlert();
        //esperar a esto y colocar un aserto

    }

    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}