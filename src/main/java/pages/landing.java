package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.KeyEvent;

public class landing {


    public WebDriver driver = null;

    @FindBy(xpath="//*[@id='content']/div/div[2]/div/div[1]/span")
    WebElement Hamburger_menu;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/section[1]/div[1]/div/div[1]/div/div/button")
    WebElement createArticle;


    @FindBy(xpath="//*[@id='content']/div/header/nav/div/div[2]/ul[1]/li[2]/a/span")
    WebElement MiT_btn;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div[3]/div/div[2]")
    WebElement shout_input;


    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[2]/div/input")
    WebElement shout_title;
    @FindBy(xpath="//*[@id='richEditor']/div/div[2]/div/div/div/div")
    WebElement shout_body;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[1]/div")
    WebElement shout_image;
    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[3]/div[2]/div/div/div/div")
    WebElement shout_image_url;
    @FindBy(xpath="/html/body/div[5]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/input")
    WebElement shout_image_input;


    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[3]/div/div")
    WebElement shout_shoutVideo;
    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[3]/div[2]/div/div/div/div/span")
    WebElement shout_AddVideo;
    @FindBy(xpath="/html/body/div[5]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/input")
    WebElement shout_videoLink;


    @FindBy(xpath="")
    WebElement shout_link;
    @FindBy(xpath="")
    WebElement shout_meme;
    @FindBy(xpath="")
    WebElement shout_nsfw;
    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[3]/button")
    WebElement shout_btn;

    //*[@id="content"]/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[3]/div[2]/div/div/div/div/span
    @FindBy(xpath="/html/body/div[5]/div[2]/div/div/div[2]/div[2]/div[2]/button")
    WebElement shout_btn_image;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/div[1]/div/div[3]/div[1]/div[3]/div[2]/div/div")
    WebElement shout_bar;



    public landing(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createArticleClick()
    {
        createArticle.click();
    }


    public void clickMIT() {

        Actions builder = new Actions(driver);
        builder.moveToElement(MiT_btn).click().perform();

    }

    public void byeHamburguer()
    {
        try {
            if (Hamburger_menu.isDisplayed() == true) {
                try {
                    Actions builder = new Actions(driver);
                    builder.moveToElement(shout_input).moveByOffset(500, 500).click().perform();
                } catch (Exception e) {
                }
            }
        }catch (Exception e) {
        }




    }

    public void createShout() {

      Actions builder = new Actions(driver);
      builder.moveToElement(shout_input).click().perform();
      builder.moveToElement(shout_input).click();

    }
    public void createShout2() {


        Actions builder = new Actions(driver);
        builder.moveToElement(shout_input).click();
       // builder.moveToElement(shout_input).click().perform();

    }



    public void writeShoutTitle(String title) {

        Actions builder = new Actions(driver);
        builder.moveToElement(shout_title).click().perform();
        shout_title.sendKeys(title);

    }

    public void writeShoutBody(String body) {

        Actions builder = new Actions(driver);
        builder.moveToElement(shout_body).click().perform();
        shout_body.sendKeys(body);
    }

    public void publishShout() {
      shout_btn.click();
    }
    public void publishShoutImage() {
        shout_btn_image.click();
    }

    public void pressImage()
    {
        Actions builder = new Actions(driver);
       // builder.moveToElement(shout_image).perform();
        builder.moveToElement(shout_image).click().perform();

    }

    public void addUrlPhoto() {


        Actions builder = new Actions(driver);
       // builder.moveToElement(shout_image_url).perform();
        builder.moveToElement(shout_image_url).click().perform();
        shout_image_input.sendKeys("https://img.freepik.com/free-vector/triangular-dark-polygonal-background_23-2148261453.jpg?size=626&ext=jpg");
        shout_image_input.sendKeys(Keys.ENTER);
    }


    public void pressVideo() {
        Actions builder = new Actions(driver);
        //builder.moveToElement(shout_shoutVideo).perform();
        builder.moveToElement(shout_shoutVideo).click().perform();

    }
    public void addUrlVideoPop() {
        Actions builder = new Actions(driver);
        builder.moveToElement(shout_AddVideo).perform();
        builder.moveToElement(shout_AddVideo).click();
                //.perform();
        //shout_AddVideo.click();
    }

    public void addUrlVideo() {
        Actions builder = new Actions(driver);
        builder.moveToElement(shout_bar).perform();
        builder.moveToElement(shout_videoLink).click().perform();
        shout_videoLink.sendKeys("https://www.youtube.com/watch?v=MI6fLRcLg_E");
        shout_videoLink.sendKeys(Keys.ENTER);
    }


}
