package Taringa.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.new_login_pom;

public class facebookLogin_test {
    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();
    }

        @Test
    public void facebookLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);
        String facebook_user = Driver.return_Prop().getProperty("facebookuser");
        String facebook_pass =Driver.return_Prop().getProperty("facebookpass");
        nl_pom.FacebookLogin(facebook_user,facebook_pass);
        Driver.implicitwait();
      }

    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}
