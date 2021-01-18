package pom;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.personalPage;
import pages.tutorPage;

public class aplicantTypeStudientPOM {


    @FindBy(xpath="")
    WebElement replacethis;

    driver driver = null;
    personalPage perPage = null;
    tutorPage turPage = null;



    public aplicantTypeStudientPOM(driver driver) {
      this.driver = driver;
      perPage = new personalPage(this.driver);

    }

    public void fillForm() throws InterruptedException {

    perPage.selectDate();





    }
}
