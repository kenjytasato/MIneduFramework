package pages;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tutorPage {

    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath="")
    WebElement createArticle;

    public tutorPage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

public void getTitle()
{

}





}
