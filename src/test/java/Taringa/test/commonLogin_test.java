package Taringa.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.new_login_pom;

public class commonLogin_test {

    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();
    }

    @Test
    public void commonLogin() throws InterruptedException {

        Driver.goto_url(Driver.return_Prop().getProperty("env"));
        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());
        nl_pom.loginDriver (Driver);

        nl_pom.writeUser(Driver.return_Prop().getProperty("user"));
        nl_pom.writePassword(Driver.return_Prop().getProperty("password"));
        nl_pom.pressLogin();
        Driver.implicitwait();
        Driver.implicitwait();
        Driver.signoutpre();
        Driver.implicitwait();
        Driver.signoutpost();
        Driver.implicitwait();

    }
    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}

