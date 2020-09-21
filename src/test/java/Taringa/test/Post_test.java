package Taringa.test;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.landing;
import pages.writePost_page;
import pom.new_login_pom;

public class Post_test {

    driver Driver =null;
    WebElement we = null;

    @BeforeClass
    public void setupEnv()
    {
        Driver = new driver();

    }
    @Test(priority = 0)
    public void commonLogin() throws InterruptedException {
     //Driver.goto_url("https://taringa.net/login");
      Driver.goto_url("https://s-beta.taringa.net/login");

        new_login_pom nl_pom = new new_login_pom(Driver.returnDriver());

        nl_pom.writeUser(Driver.return_Prop().getProperty("user"));
        nl_pom.writePassword(Driver.return_Prop().getProperty("password"));
        nl_pom.pressLogin();

    }


    @Test(priority=1)
    public void PostArticle_Profile()
    {
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());
        Landing.createArticleClick();
        wp.setPostTitle();
        wp.setPostBody();
        wp.publishPost();
        Driver.implicitwait();

    }


    @Test(priority=2)
    public void PostArticle_Channel() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net/create");
        Driver.implicitwait();
      //  landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        //Landing.createArticleClick();

        wp.selectChannel();
        wp.searchChannel();
        Driver.implicitwait();
        wp.selectChannelOption();
        wp.setPostTitle();
        wp.setPostBody();
        wp.publishPost();

    }

    @Test(priority=3)
     public void PostArticle_PhotosFromUrl() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
        wp.pressPhoto();
        Driver.implicitwait();
        Driver.switchWindows();
        wp.addUrlPhoto();

        wp.publishPost();
        Driver.implicitwait();

    }

    @Test(priority=4) // hay que modificarlo para subir algo de la pc y bla bla bla
    public void PostArticle_PhotosFromPC() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
        wp.pressPhoto();
        Driver.implicitwait();
        Driver.switchWindows();
        wp.addUrlPhoto();

        wp.publishPost();
        Driver.implicitwait();

    }

    @Test(priority=5)
    public void PostArticle_video() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
        wp.pressVideo();
        Driver.implicitwait();
        Driver.switchWindows();
        wp.addUrlVideo();
        Driver.switchWindows();

        wp.publishPost();
        Driver.implicitwait();
        Driver.implicitwait();

    }

    @Test(priority=6)
    public void PostArticle_link() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
        wp.pressLink();
        Driver.implicitwait();
        Driver.switchWindows();
        wp.addUrlLink();
        Driver.switchWindows();

        wp.publishPost();
        Driver.implicitwait();
        Driver.implicitwait();

    }


    @Test(priority=7)
    public void PostArticle_nsfw() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
     wp.pressNsfw();

        wp.publishPost();
        Driver.implicitwait();
        Driver.implicitwait();

    }
    @Test(priority=8)
    public void PostArticle_tag() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.setPostTitle();
        wp.setPostBody();

        Driver.implicitwait();
        wp.addtag(3);

        wp.publishPost();
        Driver.implicitwait();
        Driver.implicitwait();

    }

    @Test(priority=9)
    public void PostArticle_source() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.selectChannel();
        wp.searchChannel();
        Driver.implicitwait();
        wp.selectChannelOption();
        wp.setPostTitle();
        wp.setPostBody();
        wp.publishPost();

    }
    /*
    @Test(priority=10)
    public void PostArticle_complete() throws InterruptedException {

        Driver.goto_url("https://s-beta.taringa.net");
        Driver.implicitwait();
        landing Landing = new landing(Driver.returnDriver());
        writePost_page wp = new writePost_page(Driver.returnDriver());

        Landing.createArticleClick();

        wp.selectChannel();
        wp.searchChannel();
        Driver.implicitwait();
        wp.selectChannelOption();
        wp.setPostTitle();
        wp.setPostBody();
        wp.publishPost();

    }
*/
    @AfterClass
    public void teardown()
    {
        Driver.teardown();
    }
}
