package Utilities;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;


public class ExcelManager {

    public XSSFWorkbook workbook;
    public XSSFSheet Sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public FileInputStream fis;
    public String[][] sheetData = null;

    public String[][] getExcelData(String fileName, String SheetName) {
        try {

            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            fis.close();
            int rowCount = getRowCount(SheetName);
            int colCount = getColumnCount(SheetName);
            sheetData = new String[rowCount - 1][colCount];
            for (int i = 2; i <= rowCount; i++)
                for (int j = 0; j < colCount; j++)
                    sheetData[i - 2][j] = getCellDataXLSX(SheetName, j, i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return sheetData;
    }


    public int getRowCount(String sheetName) {
        int number = 0;
        Sheet = workbook.getSheet(sheetName);
        number = Sheet.getLastRowNum() + 1;


        return number;
    }

    public int getColumnCount(String sheetName) {
        int count = 0;
        Sheet = workbook.getSheet(sheetName);
        row = Sheet.getRow(0);
        if (row == null)
            return -1;
        count = row.getLastCellNum();

        return count;
    }

    public String getCellDataXLSX(String sheetName, int colNum, int rowNum) {
        String cellData = "";


        Sheet = workbook.getSheet(sheetName);
        row = Sheet.getRow(rowNum - 1);
        if (row == null) {
            return cellData;
        }
        cell = row.getCell(colNum);
        if (cell == null) {
            return cellData;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
                || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            String cellText = String
                    .valueOf(cell.getNumericCellValue());
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                // format in form of D/M/YY
                double d = cell.getNumericCellValue();
                Calendar cal = Calendar.getInstance();
                cal.setTime(HSSFDateUtil.getJavaDate(d));
                int Year = cal.get(Calendar.YEAR);
                int Day = cal.get(Calendar.DAY_OF_MONTH);
                int Month = cal.get(Calendar.MONTH) + 1;
                cellText = Day + "/" + Month + "/"
                        + (String.valueOf(Year)).substring(2);
            }
            return cellText;
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return cellData;
        } else {
            cellData = String.valueOf(cell.getBooleanCellValue());
        }
        return cellData;
    }


}