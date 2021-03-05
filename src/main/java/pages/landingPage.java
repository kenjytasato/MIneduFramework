package pages;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {


    public driver Driver = null;

    @FindBy(xpath="//*[@id='root']/header/div/button/span[1]/img")
    WebElement CertificadoEstudiosTitle;

    @FindBy(xpath="//*[@id='root']/header/div/div/ul/li/img")
    WebElement MineduLogo;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[1]/div/div")
    WebElement InformativeText;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/div[1]/img")
    WebElement singleCertificateImage;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/h4")
    WebElement singleCertificateText;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/button")
    WebElement singleCertificateBtn;


    //SingleCertificate Modal
    @FindBy(xpath="//*[@id='classic-modal-slide-description']")
    WebElement SingleCertificateModalText;
    @FindBy(xpath="/html/body/div[4]/div[3]/div/div[2]/button[1]")
    WebElement CancelBtn;
    @FindBy(xpath="/html/body/div[4]/div[3]/div/div[2]/button[2]")
    WebElement AcceptBtn;
    /////////

       @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[2]/div/div[1]/img")
    WebElement CheckCertificateImage;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[2]/div/div[2]/h4")
    WebElement CheckCertificateText;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[2]/div/div[2]/button")
    WebElement CheckCertificateBtn;

    @FindBy(xpath="//*[@id='root']/div[2]/footer/div/div[1]/div/div/div/div/h6")
    WebElement semiFooterTitle;

    @FindBy(xpath="//*[@id='root']/div[2]/footer/div/div[1]/div/div/div/div/div/div/p")
    WebElement semiFooterBody;


    public landingPage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver() , this);
        Driver.implicitwait();
    }

    public boolean checkElementsCertificadoEstudiosTitle() {
        boolean response = this.Driver.missingElement(CertificadoEstudiosTitle);
        return response;
    }

    public boolean checkElementsMineduLogo() {
        boolean response = this.Driver.missingImageElement(MineduLogo);
        return response;
    }

    public boolean checkElementsInformativeText() {
        boolean response = this.Driver.missingElement(InformativeText);
        return response;
    }

    public boolean checkElementssingleCertificateImage() {
        boolean response = this.Driver.missingImageElement(singleCertificateImage);
        return response;
    }

    public boolean checkElementssingleCertificateText() {
        boolean response = this.Driver.missingElement(singleCertificateText);
        return response;
    }

    public boolean checkElementssingleCertificateBtn() {
        boolean response = this.Driver.missingElement(singleCertificateBtn);
        return response;
    }

    public boolean checkElementsmultipleCertificateImage() {
        boolean response = this.Driver.missingImageElement(CheckCertificateImage);
        return response;
    }

    public boolean checkElementsmultipleCertificateText() {
        boolean response = this.Driver.missingElement(CheckCertificateText);
        return response;
    }

    public boolean checkElementsmultipleCertificateBtn() {
        boolean response = this.Driver.missingElement(CheckCertificateBtn);
        return response;
    }

    public boolean checkElementssemiFooterTitle() {
        boolean response = this.Driver.missingElement(semiFooterTitle);
        return response;
    }

    public boolean checkElementssemiFooterBody() {
        boolean response = this.Driver.missingElement(semiFooterBody);
        return response;
    }

    public void applyForCertificate()
    {
        Driver.explicitWait(singleCertificateBtn);
        singleCertificateBtn.click();


    }
    public void pressCertificateAccept()
    {
        Driver.explicitWait(AcceptBtn);
        AcceptBtn.click();
    }

    public void pressCertificateCancel()
    {
        Driver.explicitWait(CancelBtn);
        CancelBtn.click();
    }

    public void checkCertificate()
    {
        CheckCertificateBtn.click();


    }


}
