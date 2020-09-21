package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class driver {



    //*[@id="content"]/div/header/nav/div/div[2]/ul[2]/li[3]/span
    @FindBy( xpath ="//*[@id='content']/div/header/nav/div/div[2]/ul[2]/li[3]/span")
    WebElement tagUser_btn;
    //cerrar sesion

    @FindBy(xpath="//*[@id='content']/div/header/nav/div/div[2]/ul[2]/div/div[6]/div/span")
    WebElement signOut_label;
//home bar
    @FindBy(name="//*[@id='content']/div/header/nav/div/div[2]")
    WebElement home_bar;



    public Properties p=null;
    public WebDriver driver;
    public FileReader reader=null;
    public WebDriver returnDriver()
    {
        return driver;
    }

    public static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public driver()
    {
        setupClass();
        setupTest();

        try{
            String prop_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"env/variables.properties";
            FileReader readeri =new FileReader(prop_path);
            reader = readeri;
            p = new Properties();
            p.load(reader);
            }
        catch(Exception e)
        {
            System.out.println("el archivo de variables del sitio no se cargo de manera adecuada");
            e.printStackTrace();
        }
        PageFactory.initElements(this.driver, this);
    }
    public void explicitWait(WebElement element)
    {
        String elementoClass = element.getAttribute("class");
        System.out.println(elementoClass);
        String elementoPath = "//div[@class='"+ elementoClass + "']";
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementoPath)));

    }
    public void customWait_xpath (By taringaPath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(taringaPath));
    }
    public void customWait_clickable (By taringaPath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(elementToBeClickable(taringaPath));
    }



    public void send_keys(By taringaElement, String taringainput)
    { driver.findElement(taringaElement).sendKeys(taringainput);

    }
    public void goto_url(String url_address) throws InterruptedException {
        driver.get(url_address);
        Thread.sleep(5000);
    }
    public void findelemento(By taringaPath)
    {
        driver.findElement(taringaPath);
    }


    public void click (By taringapath)
    {
        driver.findElement(taringapath).click();
           }
    public void switchWindows()
    {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
// Perform the click operation that opens new window
// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
// Perform the actions on new window
// Close the new window, if that window no more required
//   driver.close();
// Switch back to original browser (first window)
    //    driver.switchTo().window(winHandleBefore);


    }

    public void implicitwait() {

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
    }




    public void submit(By form) {
    driver.findElement(form).submit();
    }

    public void signoutpre() {

        tagUser_btn.click();
    }
    public void signoutpost() {


        signOut_label.click();
    }

    public Properties return_Prop() {

        return p;
    }




}
