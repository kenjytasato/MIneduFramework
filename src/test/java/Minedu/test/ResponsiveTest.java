package Minedu.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.aplicantTypeStudientPOM;
import pom.landingPOM;
import pom.personTypePOM;
import utilities.report;

import java.text.ParseException;

public class ResponsiveTest {

    driver Driver = null;
    WebElement we = null;
    report Report = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver(1);

    }
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting Demo Testing Minedu");
        Report = new report();
    }

/*
    @Test(priority = 1, testName = ("demo"))
    public void commonLogin() throws InterruptedException {

        //Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        Driver.goto_url("https://certificado.minedu.gob.pe:4545/certificate");

        landingPOM lp = new landingPOM(Driver);
        lp.fillForm();
        Assert.assertEquals( lp.checkmodularCode(), "0334722" );

        /*
        applyForCertificatePage afc = new applyForCertificatePage(Driver);

        Driver.implicitwait();
      //  afc.selectComboValue("lima");
        afc.selectDepartmentComboValue(Driver.return_Prop().getProperty("department"));
        afc.selectProvinceComboValue(Driver.return_Prop().getProperty("province"));
        afc.selectDistrictComboValue(Driver.return_Prop().getProperty("district"));
        afc.writeModularCode(Driver.return_Prop().getProperty("modularCode"));
        afc.search();
        afc.selectSrlCheckbox();
        afc.clickAcceptBtn();
        Driver.implicitwait();
        Driver.implicitwait();


    }*/

    @Test(priority = 2, testName = ("e2e"))
    public void test() throws InterruptedException, ParseException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        landingPOM lp = new landingPOM(Driver);
        lp.applyForCertificate();
        aplicantTypeStudientPOM atd = new aplicantTypeStudientPOM(Driver);
        personTypePOM ptP = new personTypePOM(Driver);
 //       lp.fillForm();
        ptP.selectPersonal();
        atd.fillForm("ZENON", "MARIA DILCIA", "2001", "dic", "25", 77534344);

        Assert.assertEquals(lp.checkmodularCode(), "0334722");

        Driver.implicitwait();
    }

        @Test(priority = 3, testName = ("HU001"))
                public void test96()
        {
        }
    @Test(priority = 3, testName = ("HU002-1"))
    /*Usuario cuente con permisos para emitir certificado para la I.E. y selecciona en el menú y submenú la opción "Mi Certificado"*/
    public void HU002_1()
    {
    }
    @Test(priority = 3, testName = ("HU002-2"))
    /*Usuario cuente con permisos para emitir certificado para la I.E. y selecciona en el menú y submenú la opción "Mi Certificado"*/
    public void HU002_2()
    {
    }





    @AfterClass
    public void teardown()
    {   Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}