package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelManager {
    WebDriver driver;

    public void ExcelReader() throws Exception{

        File file = new File("C:\\Users\\Engab\\Desktop\\ReadData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);

        String searchData1 = cell.getStringCellValue();


    }
}
