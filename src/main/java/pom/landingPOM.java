package pom;

import driver.driver;
import pages.applyForCertificatePage;
import pages.termsAndConditionsPage;

public class landingPOM {

    driver Driver = null;
    public landingPOM(driver Driver)
    {
        this.Driver =Driver;
    }

    public void fillForm() throws InterruptedException {


        //Driver.goto_url("https://certificado.minedu.gob.pe:4545/");
        Driver.goto_url("https://certificado.minedu.gob.pe:4545/certificate");


        applyForCertificatePage afc = new applyForCertificatePage(Driver);
        Driver.implicitwait();
        //  afc.selectComboValue("lima");
        afc.selectDepartmentComboValue(Driver.return_Prop().getProperty("department"));
        afc.selectProvinceComboValue(Driver.return_Prop().getProperty("province"));
        afc.selectDistrictComboValue(Driver.return_Prop().getProperty("district"));
        afc.writeModularCode(Driver.return_Prop().getProperty("modularCode"));
        System.out.println(Driver.return_Prop().getProperty("modularCode"));
        afc.search();
        afc.selectSrlCheckbox();
        afc.clickAcceptBtn();
        Driver.implicitwait();
        Driver.implicitwait();

        termsAndConditionsPage tyc = new termsAndConditionsPage (Driver);
        tyc.checkcheckbox();
        tyc.ClickAcceptButton();
        Driver.implicitwait();


    }

    public String checkmodularCode ()
    {
        return Driver.return_Prop().getProperty("modularCode");
    }
}