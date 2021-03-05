package pom;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.applyForCertificatePage;
import pages.personalPage;
import pages.tutorPage;

import java.text.ParseException;

public class aplicantTypeStudientPOM {

    driver driver = null;
    personalPage perPage = null;
    tutorPage turPage = null;



    public aplicantTypeStudientPOM(driver driver) {
      this.driver = driver;
      perPage = new personalPage(this.driver);

    }

    public void fillForm(String Fname, String Mname, String year, String month, String day, int dni) throws InterruptedException, ParseException {

    perPage.WriteFatherName(Fname);
    perPage.WriteMotherName(Mname);
    perPage.selectDate(year,month,day);
    perPage.WriteDNI(dni);

    perPage.selectDepartmentComboValue(driver.return_Prop().getProperty("departmentCED009_1_2"));
    perPage.selectProvinceComboValue(driver.return_Prop().getProperty("provinceCED009_1_2"));
    perPage.selectDistrictComboValue(driver.return_Prop().getProperty("districtCED009_1_2"));
    //perPage.pressAccept();


    }

    public boolean checkElements()
    {

       return perPage.checkElement();
    }

    public void pressAccept()
    {
        perPage.pressAccept();
    }

    public void pressCancel()
    {
        perPage.pressCancel();
    }

    public void pressConfirmAccept()
    {

        perPage.pressConfirmAccept();
    }
    public void pressConfirmcancel()
    {
        perPage.pressConfirmCancel();
    }

    public Boolean checkCancelText()
    {
        return perPage.checkCancelText();
    }


}
