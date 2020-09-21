package Taringa.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.new_login_pom;

public class gmailLogin_test {
    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();
    }

    @Test
    public void gmailLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);

        String gmail_user = Driver.return_Prop().getProperty("gmailuser");
        String gmail_pass =Driver.return_Prop().getProperty("gmailpass");
        nl_pom.gmailLogin(gmail_user,gmail_pass);
        Driver.implicitwait();


    }
    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}
