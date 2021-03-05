package pom;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.applyForCertificatePage;
import driver.driver;
import pages.applyForCertificatePage;
import pages.landingPage;
import pages.termsAndConditionsPage;



public class applyForCertificatePOM {

driver Driver = null;
    applyForCertificatePage afc =null;

    public applyForCertificatePOM(driver Driver) {
        this.Driver = Driver;
        afc = new applyForCertificatePage(Driver);
    }
    public void fillForm(String department,String province,String district,String  modularCode) throws InterruptedException {



        System.out.println(Driver.return_Prop().getProperty(department));
        System.out.println(Driver.return_Prop().getProperty(province));
        System.out.println(Driver.return_Prop().getProperty(district));

        afc.selectDepartmentComboValue(Driver.return_Prop().getProperty(department));
        afc.selectProvinceComboValue(Driver.return_Prop().getProperty(province));
        afc.selectDistrictComboValue(Driver.return_Prop().getProperty(district));
        afc.writeModularCode(Driver.return_Prop().getProperty(modularCode));
        afc.search();
        afc.selectSrlCheckbox();
        afc.clickAcceptBtn();

    }

    public boolean checkCertificate()
    {
        return afc.checkPresentLogo();

    }

    public String checkBodyDescription() {

        String description = afc.returnDescription();
        return description;

    }
    public String checkTabDescription() {

        String description = afc.returnTabDescription();
        return description;

    }


}
