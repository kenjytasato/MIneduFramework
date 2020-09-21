package pom;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class new_login_pom {


   public WebDriver driver = null;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div/section/form/div[2]/div/label/div/input")
    WebElement user;
    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div/section/form/div[3]/div/label/div/input")
    WebElement password;
    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div/section/form/button")
    WebElement btnLogin;



    //facebook login

    @FindBy(xpath=  "//*[@id='content']/div/div[5]/main/div/section/form/div[6]/div[2]/button[2]")
    WebElement facebookBtn;
    @FindBy(xpath="//input[@class='inputtext _55r1 inputtext inputtext' and @id='email']")
    WebElement fb_userInput;
    @FindBy(xpath="//*[@id='pass']")
    WebElement fb_userPass;
    @FindBy(xpath="//*[@id='loginbutton']")
    WebElement fb_login;


    //gmail login


    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div/section/form/div[6]/div[2]/button[1]")
    WebElement gmailBtn;
    @FindBy(xpath="//input[@class='whsOnd zHQkBf' and @id='identifierId']")
    WebElement gmail_mail;
    @FindBy(xpath="//input[@class='whsOnd zHQkBf' and @name='password']")
    WebElement gmail_pass;



    driver dr =null;
    public new_login_pom(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void loginDriver(driver driver2)
    {
        dr = driver2;
   }


    public void loginClick()
    {
        user.click();
    }

    public void writeUser(String user)
    {

      loginClick();
      this.user.sendKeys(user);

    }
    public void passwordClick()
    {
        password.click();
    }

    public void writePassword(String password)
    {

        passwordClick();
        this.password.sendKeys(password);
    }
    public void pressLogin()
    {

        btnLogin.submit();
    }


    public void gmailLogin(String gmailuser, String gmailpass) {

       gmailBtn.click();
        dr.implicitwait();

        dr.switchWindows();
        gmail_mail.sendKeys(gmailuser);
        dr.implicitwait();
        dr.implicitwait();
        //gmail_mail_btn.click();
     gmail_mail.sendKeys(Keys.ENTER);
     dr.implicitwait();
     gmail_pass.sendKeys(gmailpass);
     dr.implicitwait();
      gmail_pass.sendKeys(Keys.ENTER);
        dr.implicitwait();

    }

    public void FacebookLogin(String facebook_user,String facebook_pass) {


        facebookBtn.click();
        dr.implicitwait();
        dr.switchWindows();

        fb_userInput.sendKeys(facebook_user);
        dr.implicitwait();
        fb_userPass.sendKeys(facebook_pass);
        dr.implicitwait();
        fb_login.click();
        dr.implicitwait();

    }

}
