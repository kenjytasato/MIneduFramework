package Minedu.test;

import driver.driver;
import org.openqa.selenium.By;
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
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

import java.text.ParseException;
import java.util.List;

public class CED001 {

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

    @Test(priority = 1, testName = ("demo"))
    public void commonLogin() throws InterruptedException {

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        Point point;
        Dimension dimension;

        List<WebElement> elementsList = Driver.returnDriver().findElements(By.xpath("//some/xpath"));

        for (WebElement element : elementsList)
        {
            point = element.getLocation();
            dimension = element.getSize();
            System.out.println("Element name: " + element.getTagName());
            System.out.println("Element size: " + dimension.height + "x" + dimension.width);
            System.out.println("Element location: " + point.x + ":" + point.y);
        }

    }
/*
    @Test(priority = 1, testName = ("CED002"))
    public void CED002() throws InterruptedException, ParseException {

        landingPOM lp = new landingPOM(Driver);
        aplicantTypeStudientPOM atd = new aplicantTypeStudientPOM(Driver);
        personTypePOM ptP = new personTypePOM(Driver);
        applyForCertificatePOM afcp = new applyForCertificatePOM(Driver);

        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");

        lp.applyForCertificate();
        afcp.fillForm("department", "province", "district", "modularCode");
        lp.acceptTermAndConditions();
        ptP.selectPersonal();
        atd.fillForm("ZENON", "MARIA DILCIA", "2001", "dic", "25", 77534344);
        Assert.assertEquals(lp.checkmodularCode(), "0334722");
    }*/



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