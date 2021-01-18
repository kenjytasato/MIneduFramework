package pages;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class personType {

    public driver Driver = null;
    public WebDriver driver = null;



    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[3]/div/div[3]/div/span/span[1]/input")
    WebElement personalTitle;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[3]/div/div[2]/div/span/span[1]/input")
    WebElement tutorTitle;
    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[2]/button")
    WebElement continueBtn;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[1]/button")
    WebElement cancelBtn;

    /*
    @FindBy(xpath="")
    WebElement createArticle;
    */


    public personType(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

public void selectPersonal()
{
personalTitle.click();
}

public void selectTutor()
{
    tutorTitle.click();
}
public void pressContinue()
{
    continueBtn.click();
}

public void pressCancel()
{
    cancelBtn.click();
}





}
