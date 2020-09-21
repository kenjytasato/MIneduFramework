package test;

import driver.driver;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.deslogueado_pom;
import pom.google;
import pom.new_login_pom;

public class new_login_comon_test {

    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();
    }

    @Test(priority = 1)
    public void commonLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);

        nl_pom.writeUser(Driver.return_Prop().getProperty("user"));
        nl_pom.writePassword(Driver.return_Prop().getProperty("password"));
        nl_pom.pressLogin();
        Driver.implicitwait();
        Driver.implicitwait();  Driver.implicitwait();  Driver.implicitwait();
        Driver.signoutpre();
        Driver.implicitwait();
        Driver.signoutpost();
        Driver.implicitwait();

    }

    @Test(priority = 2)
    public void facebookLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);
        String facebook_user = Driver.return_Prop().getProperty("facebookuser");
        String facebook_pass =Driver.return_Prop().getProperty("facebookpass");
        nl_pom.FacebookLogin(facebook_user,facebook_pass);
        Driver.implicitwait();
        Driver.signoutpre();
        Driver.implicitwait();
        Driver.signoutpost();
        Driver.implicitwait();

    }


    @Test(priority = 3)
    public void gmailLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);

        String gmail_user = Driver.return_Prop().getProperty("gmailuser");
        String gmail_pass =Driver.return_Prop().getProperty("gmailpass");
        nl_pom.gmailLogin(gmail_user,gmail_pass);
        Driver.implicitwait();
        Driver.signoutpre();
        Driver.implicitwait();
        Driver.signoutpost();
        Driver.implicitwait();
        Driver.implicitwait();
        Driver.implicitwait();

    }
    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}
