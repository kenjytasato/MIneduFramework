package pages;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkCertificatePage {


    public driver Driver = null;

    @FindBy(xpath="//*[@id='root']/header/div/button/span[1]/img")
    WebElement CertificadoEstudiosTitle;

    @FindBy(xpath="//*[@id='root']/header/div/div/ul/li/img")
    WebElement MineduLogo;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div")
    WebElement formTitle;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div[1]/div/label")
    WebElement CodigoVirtualTitle;

    @FindBy(xpath="//*[@id='codigo-virtual']")
    WebElement codigoVirtualInput;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div[2]/div/label")
    WebElement codeTitle;

    @FindBy(xpath="//*[@id='nunero-documento']")
    WebElement codeInput;

    @FindBy(xpath="//*[@id='recaptcha-anchor']/div[1]")
    WebElement captchaCheckbox;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div[2]/div[2]/button")
    WebElement verifyBtn;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div[2]/div[1]/button")
    WebElement cancelBtn;


    public checkCertificatePage(driver driver) {

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






    public void getTitle() {

    }





}
