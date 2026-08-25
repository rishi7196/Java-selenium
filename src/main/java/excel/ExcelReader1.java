package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {

    private String path = "excel/data.xlsx";

    public int getRowCount(String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        int rows = wb.getSheet(sheetName).getLastRowNum();
        wb.close();
        file.close();

        return rows;
    }

    public String getData(String sheetName, int row, int col) throws IOException {
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        Cell cell = wb.getSheet(sheetName).getRow(row).getCell(col);
        String data = cell.toString();

         return data;
    }
}