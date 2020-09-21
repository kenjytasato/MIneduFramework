package pages;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSInputSource;
import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class home {

    driver dr = null;

    By userEmail_txt = By.xpath("//input[@data-role='login-username']");
    By password_txt = By.xpath("//input[@data-role='login-password']");

    @FindBy(xpath="/html/body/div[9]/div[2]/div/div/div[2]/div/div[2]/div[1]/button")
    WebElement login_btn;

    By login = By.xpath("//button[@title='Login']");
    By facebookBtn = By.xpath("//button[@class='R5Cdk -dKHw _3w3QO VbE-J _10Eb8 _35wyv']");

    //facebook login
    By fb_userInput = By.xpath("//input[@class='inputtext _55r1 inputtext inputtext' and @id='email']");
    By fb_userPass = By.xpath("//*[@id='pass']");
    By fb_login = By.xpath("//*[@id='u_0_0']");



    //gmail login
    By gmailBtn = By.xpath("//button[@class='R5Cdk -dKHw _1u_Ch _15U0h _10Eb8 _35wyv']");
    By gmail_mail = By.xpath("//input[@class='whsOnd zHQkBf' and @id='identifierId']");
    //By gmail_mail_btn = By.xpath("//*[@class='U26fgb O0WRkf zZhnYe e3Duub C0oVfc M9Bg4d j7nIZb']");
    By gmail_mail_btn = By.xpath("//*[@id=/'identifierNext/']");
    By gmail_pass = By.xpath("//input[@class='whsOnd zHQkBf' and @name='password']");
    By gmail_pass_btn = By.xpath("//*[@id=/'passwordNext/']/div[2]");

    //articulo
    By writePost_btn = By.xpath("//button[@class='R5Cdk -dKHw _10Eb8 _30N9S']");



    public home(driver driver)
    {
        dr = driver;

    }

    public void writeUser(String user)
{
dr.send_keys(userEmail_txt , user);
}
    public void writePassword(String password)
{
    dr.send_keys(password_txt , password);
}

    private void presslogin() {
        dr.implicitwait();
        dr.click(login);
        dr.implicitwait();
       // dr.switchWindows();
    }

    public void gotologin() {
        try {
            //dr.goto_url("https://s-beta.taringa.net/");
            dr.goto_url("https://www.taringa.net/");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        presslogin();

    }

    public void pressLoginButton() {
     login_btn.click();

               
    }

    public void writePost() {
    }

    public void writeShout() {
    }

    public void commonLogin(String user, String password) {
        dr.implicitwait();
        dr.switchWindows();
        writeUser(user);
        writePassword(password);
        dr.implicitwait();
        pressLoginButton();
        dr.implicitwait();

    }

    public void facebookLogin() {

        logFacebook();

    }

    private void logFacebook() {
        dr.click(facebookBtn);

        dr.implicitwait();
        dr.implicitwait();
        dr.switchWindows();
        dr.send_keys(fb_userInput, "kenjytasato@hotmail.com");
        dr.implicitwait();
        dr.send_keys(fb_userPass, "44335775simobos44335775");
        dr.implicitwait();
        dr.submit(fb_login);
        dr.implicitwait();
        dr.implicitwait();

    }
    public driver returnDriver()
    {
        return dr;
    }

    public void gmailLogin() {

        dr.click(gmailBtn);
        dr.implicitwait();

        dr.switchWindows();
        dr.send_keys(gmail_mail, "kenjy.tasato@taringa.net");
        dr.implicitwait();
        dr.click(gmail_mail_btn);
        dr.implicitwait();
        dr.send_keys(gmail_pass, "44335775simobos");
        dr.implicitwait();
        dr.click(gmail_pass_btn);
        dr.implicitwait();
        dr.implicitwait();




  }
}
