package pom;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.personType;

public class personTypePOM {

  personType perType = null;
  driver driver = null;
  public personTypePOM(driver driver)
    {
        this.driver = driver;
        perType = new personType(this.driver);

            }

    public void selectPersonal()
    {
        perType.selectPersonal();
        perType.pressContinue();


    }

    public void selectTutor()
    {
        perType.selectTutor();
        perType.pressContinue();
    }

    public void doNothingWaitForAlert()
    {
        perType.waitmodalAlert();
    }

    public boolean checkdoNothingButton()
    {
     return    perType.modalAlertbtn();
    }
}
