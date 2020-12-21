package pages;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class writePost_page {


   // @FindBy(xpath = "//*[@id='content']/div/div[5]/main/main/div/div[2]/div[2]/input")
    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/main/div/div[2]/div[2]/input")

    WebElement postTitle;

    // @FindBy(xpath="//*[@class='DraftEditor-root']")


    //@FindBy(xpath = "//*[@id='richPublisher']/div/div[2]/div/div/div[2]/div/div/div/div")
    @FindBy(xpath = "//*[@id='richPublisher']/div/div[2]")
    WebElement postBody;


    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/aside/div[1]/div[2]/div[1]/button")
    WebElement postNSFWbtn;


    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/aside/div[1]/div[2]/form[1]/input")
    WebElement postTags;

    @FindBy(xpath = "//*[@id='content']/div/div[4]/main/aside/div[1]/div[2]/form[2]/div/input")
    WebElement postSources;
    @FindBy(xpath = "//*[@id='content']/div/div[4]/main/aside/div[1]/div[2]/button")
    WebElement postSourcesBtn;
    //@FindBy(xpath = "//*[@id='content']/div/div[5]/main/aside/div[1]/div[2]/button")
    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/aside/div[1]/div[2]/button[1]")
        WebElement postPublish;
    @FindBy(xpath = "//button[@id='content']")
    WebElement postDisclaimer;
    @FindBy(xpath = "//button[@id='content']")
    WebElement postAlienNotice;
///hasta aqui corrgido

    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/main/div/div[2]/div[1]/div/div/div[1]")
    WebElement channel;

    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/main/div/div[2]/div[1]/div/div/div[2]/div[1]/input")
    WebElement channelText;
    @FindBy(xpath = "//*[@id='content']/div/div[5]/main/div/main/div/div[2]/div[1]/div/div/div[2]/ul[2]/li[1]/div[1]")
    WebElement channelOption;
////////
    @FindBy(xpath = "//*[@id='richPublisher']/div/div[1]/div[2]/div")
    WebElement toolBar;


    @FindBy(xpath = "//*[@id='Imagen']")
    WebElement photoBtn;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/button[1]/input")
    WebElement importFromPC;
    @FindBy(xpath = "")
    WebElement importFromPC_input;
    @FindBy(xpath = "")
    WebElement importFromPC_submit;



    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/button[2]")
    WebElement importFromUrl;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/div/input")
    WebElement importFromUrl_input;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[3]/button[2]")
    WebElement importFromUrl_submit;

    @FindBy(xpath = "//*[@id='Video']")
    WebElement videoBtn;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/input")
    WebElement uploadVideo;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[3]/div/div[2]/button")
    WebElement uploadBtn;

    @FindBy(xpath = "//*[@id='Video']")
    WebElement linkBtn;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/div/input")
    WebElement uploadLink;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[3]/div/div[2]/button")
    WebElement uploadLinkBtn;


    @FindBy(xpath = "//*[@id='content']/div/div[5]/div/main/div[1]/section/div/div[2]/div/div[1]/div/textarea")
    WebElement commentInput;


    @FindBy(xpath = " //*[@id='content']/div/div[5]/div/main/div[1]/article/div[2]/div/div/div/div")
    WebElement aux;







    public WebDriver driver = null;

    public writePost_page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void setPostTitle() {
        String title = "este es el titulo de prueba";

        System.out.println(title);

        //postTitle.click();
        postTitle.sendKeys(title);


    }

    public void setPostBody() {

        Actions builder = new Actions(driver);
        builder.moveToElement(postBody).perform();
        builder.moveToElement(postBody).click();
        builder.moveToElement(postBody).sendKeys(postContent).perform();

    }

    public void publishPost() {
        postPublish.click();


    }

    String postContent = "Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología.Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología.Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología.Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología.Gorgosaurus libratus (gr. γοργώ, gorgō, 'terrible' y σαῦρος, sauros, «lagarto terrible») es un dinosaurio terópodo tiranosáurido, única especie del género monotípico Gorgosaurus. Vivió a finales del período Cretácico, hace entre 76,5 y 75 millones de años, durante la edad Campaniense, en lo que hoy es Norteamérica. Sus restos fósiles fueron encontrados en la provincia canadiense de Alberta. Otros restos, hallados en el estado de Montana, Estados Unidos, probablemente correspondan a este género. Los paleontólogos admiten únicamente la especie G. libratus, aunque otras especies fueron incluidas erróneamente en este género. Como todos los tiranosáuridos conocidos, Gorgosaurus fue un bípedo depredador que en su madurez pesaba más de una tonelada y medía nueve metros de largo. Mostraba docenas de afilados dientes alineados en sus mandíbulas, mientras que sus extremidades anteriores, con dos dedos, eran relativamente cortas. El género Gorgosaurus está íntimamente emparentado con Albertosaurus y, en menor proporción, con Tyrannosaurus. Los fósiles de Gorgosaurus y Albertosaurus, de hecho, son extremadamente similares, distinguiéndose sutilmente por pequeñas diferencias en los huesos del cráneo y los dientes, lo que hace que algunos expertos consideren a G. libratus como una de las especies, un sinónimo menor, del género Albertosaurus.Gorgosaurus vivió en un exuberante ambiente inundable a lo largo de la costa del mar interior occidental. Fue un superdepredador, en la cima de la cadena alimenticia, conviviendo y alimentándose de abundantes ceratópsidos y hadrosáuridos. En algunas áreas, Gorgosaurus coexistía con otro tiranosáurido, Daspletosaurus. Aunque estos animales eran aproximadamente del mismo tamaño, hay evidencia de que existía una separación en distintos nichos ecológicos entre los dos. Gorgosaurus es el tiranosáurido mejor representado en el registro fósil, con numerosos restos de especímenes que permiten a los científicos calcular con exactitud la ontogenia, desarrollo y otros aspectos de su biología..";

    public void selectChannel() {
/*        Actions builder = new Actions(driver);
        builder.moveToElement(channel).perform();
        builder.moveToElement(channel).click();
*/
        channel.click();
    }

    public void searchChannel() {
        channelText.sendKeys("star");
    }

    public void selectChannelOption() {
        channelOption.click();
    }

    public void pressPhoto() {

        Actions builder = new Actions(driver);
        builder.moveToElement(toolBar).perform();
        builder.moveToElement(photoBtn).click().perform();

    }

    public void addUrlPhoto() {
        Actions builder = new Actions(driver);
        builder.moveToElement(importFromUrl).perform();
        builder.moveToElement(importFromUrl).click().perform();
        builder.moveToElement(importFromUrl_input).perform();
        builder.moveToElement(importFromUrl_input).click().perform();
        importFromUrl_input.sendKeys("https://fotografias.lasexta.com/clipping/cmsimages02/2018/04/19/D1D14B25-F4E2-4D92-8E2B-D9282997F66B/58.jpg");
        importFromUrl_submit.click();
    }
    public void addLocalPhoto()
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(importFromUrl).perform();
        builder.moveToElement(importFromUrl).click().perform();
        builder.moveToElement(importFromUrl_input).perform();
        builder.moveToElement(importFromUrl_input).click().perform();
        importFromUrl_input.sendKeys("https://fotografias.lasexta.com/clipping/cmsimages02/2018/04/19/D1D14B25-F4E2-4D92-8E2B-D9282997F66B/58.jpg");
        importFromUrl_submit.click();
    }




    public void pressVideo() {

        Actions builder = new Actions(driver);
        builder.moveToElement(toolBar).perform();
        builder.moveToElement(videoBtn).click().perform();
        //photoBtn.click();
    }

    public void addUrlVideo() {
      /*  Actions builder = new Actions(driver);
        builder.moveToElement(uploadVideo).perform();
        builder.moveToElement(uploadVideo).click().perform();

       */
        uploadVideo.sendKeys("https://www.youtube.com/watch?v=vQGQhbUmnos");
        uploadBtn.click();
    }

    public void pressLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(toolBar).perform();
        builder.moveToElement(linkBtn).click().perform();
    }

    public void addUrlLink() {
        uploadLink.sendKeys("www.google.com");
        uploadLinkBtn.click();
    }

    public void pressNsfw() {

    postNSFWbtn.click();
    }

    public void addtag(int i) {

for (int a=0;a<i;a++)
                {
                    postTags.sendKeys("tag"+a);
                    postTags.sendKeys(Keys.SPACE);
                }
    }


    public void writecomment() {


        Actions builder = new Actions(driver);
        builder.moveByOffset(500,500).click().perform();
        commentInput.click();
        builder.moveToElement(commentInput).sendKeys(postContent);
        builder.moveToElement(commentInput).perform();

    }
}
