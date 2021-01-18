package Minedu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.excellManager;

public class ExcelPopulateData {

    public static void main(String [] args) throws InterruptedException{

        excellManager excel = new excellManager("./src/main/resources/files/Data.xlsx");
        System.out.println(excel.readData(0,0));
    }

}
