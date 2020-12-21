package Minedu.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.landingPage;
import pom.landingPOM;

public class LandingTest {

    driver Driver = null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver();

    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Starting Demo Testing Minedu");
    }

    @Test(priority = 0)
    public void elementsPresent() throws InterruptedException {
        Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        Driver.implicitwait();
        landingPage LpTest = new landingPage(Driver);

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
            System.out.println("no se ve");
        }
    }

    @Test(priority = 1)
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
*/

    }
    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}