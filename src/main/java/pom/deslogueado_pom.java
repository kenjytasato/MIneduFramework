package pom;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deslogueado_pom {

   // WebDriver driver;
    @FindBy(xpath = "")
    WebElement burger;
    @FindBy(xpath = "")
    WebElement taringa;
    @FindBy(xpath = "")
    WebElement home;
    @FindBy(xpath = "")
    WebElement global;
    @FindBy(xpath = "")
    WebElement games;
    @FindBy(xpath = "")
    WebElement signin;
    @FindBy(xpath = "//*[@title='Iniciar sesión']")
    WebElement login;
    @FindBy(xpath = "")
    WebElement hot;
    @FindBy(xpath = "")
    WebElement recent;
    @FindBy(xpath = "")
    WebElement post;

    public deslogueado_pom()
    {

        //this.driver = driver;
     //   PageFactory.initElements(driver, this);
        System.out.println("inicio la pagina");
    }
    public void loginClick() {
        login.click();
    }

    public void bringWindow() {
        login.click();
    }


    public WebElement returnWeLogin() {
        return login;
    }
}