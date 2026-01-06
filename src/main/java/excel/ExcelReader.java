package excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        
    	File f = new File("excel/data.xlsx");
        FileInputStream file = new FileInputStream(f);
        XSSFWorkbook wb= new XSSFWorkbook(file);
        Sheet sheet = wb.getSheetAt(0);// Index starts from 0

        // ✅ Step 5: Iterate Through Rows and Columns
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue()+"\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()+"\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue()+"\t");
                        break;
                    default:
                        System.out.print("Unknown Value\t");
                        break;
                }
            }
            System.out.println(); // Move to the next line
        }

        wb.close();
        file.close();
    }
}
