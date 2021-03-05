package pom;

import driver.driver;
import pages.personalPage;
import pages.tutorPage;

import java.text.ParseException;

public class aplicantTypeTutorPOM {

    driver driver = null;
   // personalPage perPage = null;
    tutorPage turPage = null;



    public aplicantTypeTutorPOM(driver driver) {
      this.driver = driver;
        turPage = new tutorPage(this.driver);

    }

    public void fillForm(String Fname, String Mname, String year, String month, String day, int dni) throws InterruptedException, ParseException {

        turPage.WriteFatherName(Fname);
        turPage.WriteMotherName(Mname);
        turPage.selectDate(year,month,day);
        turPage.WriteDNI(dni);

        turPage.selectDepartmentComboValue(driver.return_Prop().getProperty("department1"));
        turPage.selectProvinceComboValue(driver.return_Prop().getProperty("province1"));
        turPage.selectDistrictComboValue(driver.return_Prop().getProperty("district1"));
    //perPage.pressAccept();


    }

    public boolean checkElements()
    {

       return turPage.checkElement();
    }

    public void pressAccept()
    {
        turPage.pressAccept();
    }

    public void pressCancel()
    {
        turPage.pressCancel();
    }

    public void pressConfirmAccept()
    {

        turPage.pressConfirmAccept();
    }
    public void pressConfirmcancel()
    {
        turPage.pressConfirmCancel();
    }

    public Boolean checkCancelText()
    {
        return turPage.checkCancelText();
    }


}
