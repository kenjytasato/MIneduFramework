package pages;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class applyForCertificatePage {



    public driver Driver = null;

    @FindBy(xpath="//*[@id='root']/header/div/button/span[1]/img")
    WebElement CertificadoEstudiosTitle;

    @FindBy(xpath="//*[@id='root']/header/div/div/ul/li/img")
    WebElement MineduLogo;

    //form - tab 1 - "busqueda institucion"

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[1]/div")
    WebElement tabTitle;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[1]")
    WebElement bodyText;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div")
    WebElement subTabTitle;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/label")
    WebElement departmentLabel;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div/div")
    WebElement departmentCbx;


    String departmentElement1="//*[@id='menu-departamento']/div[3]/ul/li[";
    String departmentElement2="]";

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/label")
    WebElement provinceLabel;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div")
    WebElement provinceCbx;


    String provinceElement1 ="//*[@id='menu-provincia']/div[3]/ul/li[" ;
    String provinceElement2 ="]";


    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/label")
    WebElement districtLabel;

    @FindBy(xpath=" //*[@id='select-ubigeo']")
    WebElement districtCbx;

    String districtElement1="//*[@id='menu-ubigeo']/div[3]/ul/li[";
    String districtElement2="]";

    @FindBy(xpath="")
    WebElement ieNameLabel;

    @FindBy(xpath="")
    WebElement ieNameInput;

    @FindBy(xpath="")
    WebElement modularCodeLabel;

    @FindBy(xpath="//*[@id='cod-mod']")
    WebElement modularCodeInput;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/table/tbody/tr/td[8]/span/span[1]/input")
    WebElement srlRowCheckbox;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[6]/button[1]")
    WebElement searchBtn;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/table/tbody/tr/td[8]/span/span[1]/input")
    WebElement resultcheckbox;

    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[2]/button")
    WebElement acceptButton;

    public applyForCertificatePage(driver driver) {

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

    public void selectDepartmentComboValue(String value) {

        Actions builder = new Actions(Driver.returnDriver());
        Driver.explicitWait(departmentCbx);
        builder.moveToElement(departmentCbx).click().perform();
        builder.moveToElement(departmentCbx).sendKeys(value).perform();

        String aux1 =  departmentElement1 + Driver.return_Prop().getProperty("d"+value) + departmentElement2 ;

        WebElement departmentElement = Driver.driver.findElement(By.xpath(aux1));
        builder.moveToElement(departmentElement).click().perform();
        Driver.implicitwait();
    }

    public void selectProvinceComboValue(String value) {

        Actions builder = new Actions(Driver.returnDriver());
        Driver.explicitWait(provinceCbx);
        builder.moveToElement(provinceCbx).click().perform();
        builder.moveToElement(provinceCbx).sendKeys(value).perform();
        String aux2 =  provinceElement1 + Driver.return_Prop().getProperty("p"+value) + provinceElement2 ;
        WebElement departmentElement = Driver.driver.findElement(By.xpath(aux2));
        builder.moveToElement(departmentElement).click().perform();
        Driver.implicitwait();
    }

    public void selectDistrictComboValue(String value) {

        Driver.explicitWait(districtCbx);
        Actions builder = new Actions(Driver.returnDriver());
        Driver.explicitWait(districtCbx);
        builder.moveToElement(districtCbx).click().perform();
        builder.moveToElement(districtCbx).sendKeys(value).perform();
        String aux1 =  districtElement1 + Driver.return_Prop().getProperty("di" +value) + districtElement2 ;
        WebElement districtElement = Driver.driver.findElement(By.xpath(aux1));
        builder.moveToElement(districtElement).click().perform();
        Driver.implicitwait();
    }

    public void writeModularCode(String value) {

        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(modularCodeInput).click().perform();
        builder.moveToElement(modularCodeInput).sendKeys(value).perform();
       }

    public void search() {
     searchBtn.click();
    }

    public void selectSrlCheckbox()
    {
        resultcheckbox.click();
    }

    public void clickAcceptBtn()
    {
        acceptButton.click();
    }


    public boolean checkPresentLogo()
    {boolean present = Driver.missingElement(CertificadoEstudiosTitle);
    return present;
    }


    public String returnDescription() {

        String description = bodyText.getText();
        return description;
    }

    public String returnTabDescription() {

        String tabDescription = tabTitle.getText();
        return tabDescription;
    }

}
