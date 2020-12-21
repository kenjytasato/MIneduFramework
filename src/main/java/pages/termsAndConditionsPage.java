package pages;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class termsAndConditionsPage {


    public driver Driver = null;
    @FindBy(xpath="//*[@id='root']/header/div/button/span[1]/img")
    WebElement CertificadoEstudiosTitle;

    @FindBy(xpath="//*[@id='root']/header/div/div/ul/li/img")
    WebElement MineduLogo;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[2]/div[2]/label/span[1]/span[1]/input")
    WebElement acceptCheckbox;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[2]/button")
    WebElement acceptButton;

    public termsAndConditionsPage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public boolean checkElementsCertificadoEstudiosTitle() {
        boolean response = this.Driver.missingElement(CertificadoEstudiosTitle);
        return response;
    }

    public boolean checkElementsMineduLogo() {
        boolean response = this.Driver.missingImageElement(MineduLogo);
        return response;
    }

    public void checkcheckbox()
    {
        acceptCheckbox.click();
    }

    public void ClickAcceptButton() {
            acceptButton.click();
    }
}
