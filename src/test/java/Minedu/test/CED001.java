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

import utilities.report;


public class CED001 {

    driver Driver = null;
    WebElement we = null;
    report Report = null;

    @BeforeClass
    public void setupEnv(ITestContext context) {
        Driver = new driver(1, 375, 812);
        context.setAttribute("Driver", Driver);

    }


    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Starting CED001 tests");
        Report = new report();
    }

    @Test(priority = 1, testName = ("responsive testing"))
    public void CED00001_responsive_test() throws InterruptedException {


      Driver.goto_url("https://certificado.minedu.gob.pe:4545/");


        landingPage LpTest = new landingPage(Driver);

        Assert.assertEquals(LpTest.checkElementsMineduLogo(), true);
        Assert.assertEquals(LpTest.checkElementsCertificadoEstudiosTitle(), true);
        Assert.assertEquals(LpTest.checkElementsInformativeText(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateBtn(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateImage(), true);
        Assert.assertEquals(LpTest.checkElementsmultipleCertificateText(), true);
        Assert.assertEquals(LpTest.checkElementssemiFooterBody(), true);
        Assert.assertEquals(LpTest.checkElementssemiFooterTitle(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateBtn(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateImage(), true);
        Assert.assertEquals(LpTest.checkElementssingleCertificateText(), true);


    }


    @AfterClass
    public void teardown() {
        Driver.driver.manage().deleteAllCookies();
        Driver.teardown();
    }
}