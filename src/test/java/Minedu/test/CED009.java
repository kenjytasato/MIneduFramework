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

public class CED009 {

    driver Driver = null;
    WebElement we = null;
    report Report = null;
    landingPOM lp = null;
    applyForCertificatePOM afcp = null;
    aplicantTypeTutorPOM att = null;
    personTypePOM ptP = null;
    termsAndConditionsPOM tacp = null;
    landingPage LpTest = null;
    aplicantTypeStudientPOM atd = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver(1);
        lp = new landingPOM(Driver);
        afcp = new applyForCertificatePOM(Driver);
        att = new aplicantTypeTutorPOM(Driver);
        ptP = new personTypePOM(Driver);
        tacp = new termsAndConditionsPOM(Driver);
        LpTest = new landingPage(Driver);
        atd = new aplicantTypeStudientPOM(Driver);

    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Quiero registrar mi solicitud de constancia - test");
        Report = new report();
    }

    @Test(priority = 2, testName = ("CED009_1 - Interesado registra los datos academicos."))
    public void CED009_1() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("departmentCED009_1","provinceCED009_1", "districtCED009_1", "modularCodeCED009_1");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        atd.fillForm("FRANCISCO","BASILIA","1952","jul","28",10521082);
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        Driver.superwait();
        //añadir acerto que si nohayt nada




    }

    @Test(priority = 2, testName = ("CED009_2 - Interesado registra los datos de contacto."))
    public void CED009_2() throws InterruptedException, ParseException {

           Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        //añadir acerto que si nohayt nada
    }

    @Test(priority = 2, testName = ("CED009_3 - Interesado registra los datos academicos."))
    public void CED009_3() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        lp.applyForCertificate();
        lp.acceptTerms();
        afcp.fillForm("department","province", "district", "modularCode");
        personTypePOM ptP = new personTypePOM(Driver);
        ptP.selectPersonal();
        atd.fillForm("ZENON","MARIA DILCIA","2001","dic","25",77534344);
        //añadir acerto que si nohayt nada
    }

    @Test(priority = 2, testName = ("CED009_4 - Interesado registra los datos academicos."))
    public void CED009_4() throws InterruptedException, ParseException {

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

    @Test(priority = 2, testName = ("CED009_5 - interesado no registra todo los campos para la solicitud de la constancia."))
    public void CED009_5() throws InterruptedException, ParseException {

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

    @Test(priority = 2, testName = ("CED009_6 - Interesado registra los datos de contacto."))
    public void CED009_6() throws InterruptedException, ParseException {

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
    @Test(priority = 2, testName = ("CED009_7 - El interesado no continúa con el proceso."))
    public void CED009_7() throws InterruptedException, ParseException {

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

    @Test(priority = 2, testName = ("CED009_8 - El interesado no desea continuar con el proceso."))
    public void CED009_8() throws InterruptedException, ParseException {

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

    @Test(priority = 2, testName = ("CED009_9 - Interesado no realiza ni una accion."))
    public void CED009_9() throws InterruptedException, ParseException {

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

    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}