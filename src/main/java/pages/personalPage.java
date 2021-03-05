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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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

/*    @FindBy(xpath="//*[@role='button' and text()='2000']")
    WebElement bdYear;
    @FindBy(xpath="//*[@role='button' and text()='dic']")
    WebElement bdMonth;
    @FindBy(xpath="/html/body/div[9]/div[3]/div/div[1]/div/div[2]/div[2]")
    WebElement bdDay;

 */

    String bdYear ="//*[@role='button' and text()='";
    String bdYear2 =    "']";

    String bdMonth ="//*[@role='button' and text()='";
    String bdMonth2 = "']" ;



    @FindBy(xpath="/html/body/div[9]/div[3]/div/div[1]/div/div[2]/div[2]")
    WebElement bdDay;



    //parents data
    @FindBy(xpath="//*[@id='nombre-padre-estudiante']")
    WebElement fatherName;
    @FindBy(xpath="//*[@id='nombre-madre-estudiante']")
    WebElement motherName;


    //reniec data
    @FindBy(xpath="//*[@id='select-departamentoEstudiante']")
    WebElement departmentCbx;

    String departmentElement1="//*[@id='menu-departamentoEstudiante']/div[3]/ul/li[";
    String departmentElement2="]";


    @FindBy(xpath="//*[@id='select-provinciaEstudiante']")
    WebElement provinceCbx;
    String provinceElement1 ="//*[@id='menu-provinciaEstudiante']/div[3]/ul/li[" ;
    String provinceElement2 ="]";




    @FindBy(xpath="//*[@id='select-ubigeoEstudiante']")
    WebElement districtCbx;
    String districtElement1="//*[@id='menu-ubigeoEstudiante']/div[3]/ul/li[";
    String districtElement2="]";




    //  botones formulario
    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[2]/button")
    WebElement aceptarBtn;
    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[3]/div[1]/button")
    WebElement cancelarBtn;



//elemnts



    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div/div/div/div/div[2]/div[5]/div/div[2]/div/div[2]/div/div[1]/div/svg")
    WebElement xmark;

    //confirm cancel

    @FindBy(xpath="/html/body/div[10]/div[3]/div/div[3]/button[2]")
    WebElement confirmAccept;
    @FindBy(xpath="/html/body/div[10]/div[3]/div/div[3]/button[1]")
    WebElement confirmCancel;

  /*  @FindBy(xpath="//*[@id='classic-modal-slide-description']")
    WebElement confirmCancelText;*/

    @FindBy(xpath="/html/body/div[10]/div[3]/div")
    WebElement confirmCancelText;








    public personalPage(driver driver) {

        this.Driver = driver;

        PageFactory.initElements(this.Driver.returnDriver(), this);
    }


    public void selectDepartmentComboValue(String value) {

        Driver.explicitWait(departmentCbx);

        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(departmentCbx).click().perform();
        builder.moveToElement(departmentCbx).sendKeys(value).perform();

        String aux1 =  departmentElement1 + Driver.return_Prop().getProperty("d" +value) + departmentElement2 ;
        WebElement departmentElement = Driver.driver.findElement(By.xpath(aux1));
        builder.moveToElement(departmentElement).click().perform();
        Driver.implicitwait();




    }


    public void selectProvinceComboValue(String value) {

        Driver.explicitWait(provinceCbx);
        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(provinceCbx).click().perform();
        builder.moveToElement(provinceCbx).sendKeys(value).perform();

        String aux2 =  provinceElement1 + Driver.return_Prop().getProperty("p" + value) + provinceElement2 ;
        WebElement provinceElement = Driver.driver.findElement(By.xpath(aux2));
        builder.moveToElement(provinceElement).click().perform();
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

    public void selectDate(String year,String month , String day) throws InterruptedException, ParseException {
        int tempday=0;
        int realday=0;
        int realweek=0;

        tempday = dayoffset(month,year)+Integer.parseInt(day);
        realweek = (tempday/7);
        realday  = (tempday%7);
        if (realday>0)
        {
            realday=realday-1;
            realweek=realweek+1;
        }
        else
        {
            realweek=realweek+1;
        }

        //String semana = "/html/body/div[9]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[";
        String semana = "/html/body/div[11]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[";

        String semana2 = "]/div[";
        //String dia = "]/button/span[1]/p";
        String dia = "]/button";
        String auxpath = "";
        auxpath= semana + realweek + semana2 + realday + dia;


        datepik.click();
        Driver.findby(bdYear+year+bdYear2).click();
        Driver.findby(bdMonth+month+bdMonth2).click();

        Driver.findby(auxpath).click();

             }


        public int dayoffset(String month, String year) throws ParseException {
            String newmonth = changemonth(month);
            String sDate1="01"+"/"+ newmonth+"/"+year;
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            System.out.println(date1);
            int dayWeek = getDayNumberOld(date1)-1;
            System.out.println(dayWeek);

        return dayWeek;
        }




    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public String changemonth(String month)
    {String modmonth ="";

        switch(month) {
            case "ene": modmonth = "01";break;
            case "feb": modmonth = "02";break;
            case "mar": modmonth = "03";break;
            case "abr": modmonth = "04";break;
            case "may": modmonth = "05";break;
            case "jun": modmonth = "06";break;
            case "jul": modmonth = "07";break;
            case "ago": modmonth = "08";break;
            case "sep": modmonth = "09";break;
            case "oct": modmonth = "10";break;
            case "nov": modmonth = "11";break;
            default:return "12";
                // code block

        }


        return modmonth;
    }

    public void test(String select_day) {

        //itereacion x semana
        String semana = "/html/body/div[9]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[";
        String semana2 = "]/div[";
        String dia = "]/button/span[1]/p";
        String auxpath = "";

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 32; j++) {

            auxpath= semana + i + semana2 + j + dia;
                System.out.println(auxpath);
                if (checkchec(auxpath) == true && Driver.findby(auxpath).getText() == select_day )
                {
                    System.out.println("le voy a dar click");
                     Driver.findby(auxpath).click();
                }
            }
        }
    }

    public boolean checkchec(String ruta)

    {
        System.out.println("checkelent");
        boolean present;
        try {
           // Driver.findby(ruta);
           Driver.returnDriver().findElement(By.xpath(ruta));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        return present;
    }





     public void WriteFatherName(String name)
     {
         fatherName.sendKeys(name);
     }

    public void WriteMotherName(String name)
     {
         motherName.sendKeys(name);
     }

public void WriteDNI(int docni)
    {

    dni.sendKeys(Integer.toString(docni));

  }





public void pressAccept()
{
    //Driver.explicitWait(aceptarBtn);
    aceptarBtn.click();

}

public void pressCancel()
{   Driver.explicitWait(cancelarBtn);
    cancelarBtn.click();
}

    public void pressConfirmCancel()
    {
        Driver.explicitWait(confirmCancel);
        confirmCancel.click();
    }
    public void pressConfirmAccept()
    {
        Driver.explicitWait(confirmAccept);
        confirmAccept.click();
    }



    public boolean checkElement() {
Boolean response = true;

response = cancelarBtn.isDisplayed() && aceptarBtn.isDisplayed();

return response;
    }

    public Boolean checkCancelText() {

     Boolean   response = confirmCancel.isDisplayed() && confirmAccept.isDisplayed();

        return response;



    }
}



