package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excellManager {

    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;

    public excellManager(String excelPath)
    {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            wb = new XSSFWorkbook(fis);
            System.out.println(wb.getFirstVisibleTab());


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String readData (int row, int column ){

        sheet = wb.getSheet("data");
//        sheet = wb.getSheetAt(1);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;



    }






}

