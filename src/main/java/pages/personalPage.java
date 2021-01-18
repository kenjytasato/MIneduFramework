package pages;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class personalPage {

    public driver Driver = null;
    public WebDriver driver = null;

    //personal data
    @FindBy(xpath="//*[@id='nro-doc-estudiante']")
    WebElement dni;
    @FindBy(xpath="//*[@id='fecha-nacimiento-estudiante']")
    WebElement birthDate;



    //datepicker

    @FindBy(xpath="//*[@id='fecha-nacimiento-estudiante']")
    WebElement datepik;




    @FindBy(xpath="//*[@role='button' and text()='1987']")
    WebElement bdYear;
    @FindBy(xpath="//*[@role='button' and text()='mar']")
    WebElement bdMonth;
    @FindBy(xpath="/html/body/div[9]/div[3]/div/div[1]/div/div[2]/div[2]")
    WebElement bdDay;




    //parents data
    @FindBy(xpath="//*[@id='nombre-padre-estudiante']")
    WebElement fatherName;
    @FindBy(xpath="//*[@id='nombre-madre-estudiante']")
    WebElement MotherName;


    //reniec data
    @FindBy(xpath="")
    WebElement departmentCbx;
    String departmentElement1="//*[@id='menu-departamento']/div[3]/ul/li[";
    String departmentElement2="]";
    @FindBy(xpath="")
    WebElement provinceCbx;
    String provinceElement1 ="//*[@id='menu-provincia']/div[3]/ul/li[" ;
    String provinceElement2 ="]";
    @FindBy(xpath="")
    WebElement districtCbx;
    String districtElement1="//*[@id='menu-ubigeo']/div[3]/ul/li[";
    String districtElement2="]";






    public personalPage(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }


    public void selectDepartmentComboValue(String value) {

        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(departmentCbx).click().perform();
        builder.moveToElement(departmentCbx).sendKeys(value).perform();
        String aux1 =  departmentElement1 + Driver.return_Prop().getProperty("d" +value) + departmentElement2 ;
        WebElement departmentElement = Driver.driver.findElement(By.xpath(aux1));
        builder.moveToElement(departmentElement).click().perform();
        Driver.implicitwait();
    }

    public void selectProvinceComboValue(String value) {

        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(provinceCbx).click().perform();
        builder.moveToElement(provinceCbx).sendKeys(value).perform();
        String aux2 =  provinceElement1 + Driver.return_Prop().getProperty("p" + value) + provinceElement2 ;
        WebElement departmentElement = Driver.driver.findElement(By.xpath(aux2));
        builder.moveToElement(departmentElement).click().perform();
        Driver.implicitwait();
    }

    public void selectDistrictComboValue(String value) {

        Driver.explicitWait(districtCbx);
        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(districtCbx).click().perform();
        builder.moveToElement(districtCbx).sendKeys(value).perform();
        String aux1 =  districtElement1 + Driver.return_Prop().getProperty("di" +value) + districtElement2 ;
        WebElement districtElement = Driver.driver.findElement(By.xpath(aux1));
        builder.moveToElement(districtElement).click().perform();
        Driver.implicitwait();
    }


    public void aux(int x) throws InterruptedException {
          WebElement dateWidget = bdDay;

        Actions builder = new Actions(Driver.returnDriver());
        System.out.println("creo el builder");
        List<WebElement> columns = dateWidget.findElements(By.tagName("p"));

        System.out.println(columns.get(x+5).getText());
        //columns.get(14).click();
        builder.moveToElement(columns.get(x+5)).perform();
        builder.moveToElement(columns.get(x+5)).click().perform();
      //  builder.moveToElement(columns.get(14)).doubleClick();

        /*
        for (WebElement cell : columns) {
            //Select 13th Date

            if (cell.getText().equals("15")) {
               cell.findElement(By.linkText("15")).click();
          //     cell.findElement(By.tagName("5")).click();
           //    cell.findElement(By.name("5")).click();
            //   builder.moveToElement(cell.findElement(By.partialLinkText("5"))).perform();
             //   builder.moveToElement(cell.findElement(By.partialLinkText("5"))).click();
                System.out.println("entre al if");
                break;
            }

            System.out.println(cell.getText());*/

     //   }

    }

    public void selectDate() throws InterruptedException {
        datepik.click();
        Driver.implicitwait();
        bdYear.click();
        Driver.implicitwait();
        bdMonth.click();
        Driver.implicitwait();
          //superwait();

        aux(10);
        superwait();
        }

        public void superwait()
        {
            Driver.implicitwait();
            Driver.implicitwait();
            Driver.implicitwait();
            Driver.implicitwait(); Driver.implicitwait();
            Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait();
            Driver.implicitwait(); Driver.implicitwait(); Driver.implicitwait();
        }
    }



