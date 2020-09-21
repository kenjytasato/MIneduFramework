package Taringa.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.landing;
import pom.new_login_pom;

public class Shout_test {



    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();

    }
    @Test(priority = 1)
    public void commonLogin() throws InterruptedException {
        //Driver.goto_url(https://s-beta.taringa.net/mi");
        Driver.goto_url("https://s-beta.taringa.net/login");
        //Driver.goto_url("https://taringa.net/login");

        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());

        nl_pom.writeUser(Driver.return_Prop().getProperty("user"));
        nl_pom.writePassword(Driver.return_Prop().getProperty("password"));
        nl_pom.pressLogin();
        Driver.implicitwait();
    }
/*
    @Test(priority=2)
    public void common_shout() throws InterruptedException {
        landing Landing = new landing(Driver.returnDriver());

       //Landing.clickMIT();

        Driver.implicitwait();
        Driver.goto_url("https://s-beta.taringa.net/mi");
        Landing.byeHamburguer();
        Driver.implicitwait();
        Landing.createShout();
        Driver.implicitwait();
        Landing.writeShoutBody("common shout");
        Landing.writeShoutTitle("common shout");


        Landing.publishShout();

        Driver.implicitwait();



    }

    @Test(priority=3)
    public void shout_image() throws InterruptedException {
        landing Landing = new landing(Driver.returnDriver());

       Driver.implicitwait();
       Driver.goto_url("https://s-beta.taringa.net/mi");
       Landing.byeHamburguer();
       Driver.implicitwait();
       Landing.createShout();
       Driver.implicitwait();
       Landing.writeShoutBody("shout_image");
       Landing.writeShoutTitle("shout_image");

        Driver.implicitwait();
        Landing.pressImage();
        Driver.implicitwait();
        Landing.addUrlPhoto();
        Driver.implicitwait();
        Landing.publishShoutImage();

        Driver.implicitwait();

    }*/

    @Test(priority=4)
    public void shout_video() throws InterruptedException {
       landing Landing = new landing(Driver.returnDriver());


        Driver.implicitwait();
        Driver.goto_url("https://s-beta.taringa.net/mi");
        Landing.byeHamburguer();
        Driver.implicitwait();
        Landing.createShout();
        Driver.implicitwait();


        Driver.implicitwait();
        Landing.pressVideo();
        Driver.implicitwait();
        Landing.addUrlVideo();
        Driver.implicitwait();
        Landing.addUrlVideoPop();
        Driver.implicitwait();
       // Landing.publishShoutImage();

    }
/*
    @Test(priority=5)
    public void shout_link() throws InterruptedException {
        landing Landing = new landing(Driver.returnDriver());

        Landing.clickMIT();
        Driver.implicitwait();
        Landing.createShout();
        Landing.writeShoutBody("Shout Body");
        Landing.writeShoutTitle("shout Title");
        Driver.implicitwait();
        Landing.publishShout();

        Driver.implicitwait();

    }
    @Test(priority=6)
    public void shout_nsfw() throws InterruptedException {
        landing Landing = new landing(Driver.returnDriver());

        Landing.clickMIT();
        Driver.implicitwait();
        Landing.createShout();
        Landing.writeShoutBody("Shout Body");
        Landing.writeShoutTitle("shout Title");
        Driver.implicitwait();
        Landing.publishShout();

        Driver.implicitwait();

    }*/

    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }


}
