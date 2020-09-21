package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demo_page {


    public WebDriver driver = null;

    @FindBy(xpath="//*[@id='content']/div/div[5]/main/div[1]/section[1]/div[1]/div/div[1]/div/div/button")
    WebElement createArticle;

    public demo_page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }







}
