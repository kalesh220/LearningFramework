package utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;

public class ExcelFileHandling {

    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet workSheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public XSSFCellStyle style;

    public static int getRowsCount(String sheet, String path){
        try {
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheet);
            return workSheet.getLastRowNum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getCellsCount(String path, String sheetName, int rowNumber){
        try{
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheetName);
            row = workSheet.getRow(rowNumber);
            return row.getLastCellNum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellData(String path, String sheetName, int rowNumber, int cellNumber){
        try{
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheetName);
            row = workSheet.getRow(rowNumber);
            cell = row.getCell(cellNumber);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
