package pom;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.personType;
import driver.driver;
import pages.termsAndConditionsPage;

public class termsAndConditionsPOM {

    termsAndConditionsPage termsCon = null;
    driver driver = null;

    public termsAndConditionsPOM(driver driver)
    {
        this.driver = driver;
        termsCon = new termsAndConditionsPage(this.driver);

    }

    public void acceptTerms()
    {
          termsCon.checkcheckbox();
          termsCon.ClickAcceptButton();
    }

    public void cancel()
    {
        termsCon.cancel();
    }
    public void cancelandcontinue()
    {
        termsCon.cancelandcontinue();
    }

    public boolean checktitle()
    {
     return   termsCon.checkElementsCertificadoEstudiosTitle();
    }



}
