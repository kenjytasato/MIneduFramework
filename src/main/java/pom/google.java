package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class google {


    private final WebDriver driver;
    @FindBy(xpath="//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement googleinput;



    public google(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver , this);
    }

    public void sendsearch()
    {
        googleinput.sendKeys("hola");

    }

}
