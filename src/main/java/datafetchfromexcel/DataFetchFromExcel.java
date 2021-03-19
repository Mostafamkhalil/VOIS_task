package datafetchfromexcel;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

/*
 * A class to manipulate excel sheets
 * The purpose of this sheet is to fetch the test data from excel sheet to support Data driven
 *
 * The class contains three methods:
 * fileNameRead:                a method to define which excel sheet to read
 * getNumberOfDataUnderTitle:   a method te define the number of test data available
 *                              to test for a certain parameter
 * getStringUnderTitle:         a method to get the required data in the type of string
 */

public class DataFetchFromExcel {
    private FileInputStream file;
    private Workbook wb;
    private Sheet sheet;
    private Row row;
    private Cell cell;


    public void fileNameRead(String name){
        try {
            this.file = new FileInputStream(name);
        }
        catch (Exception e){
            System.out.println("File Not Found");
            System.out.println(e);
        }

        try {
            this.wb = WorkbookFactory.create(this.file);
        }
        catch (Exception e){
            System.out.println("Workbook Not created");
            System.out.println(e);
        }

        this.sheet = this.wb.getSheet("Sheet1");
        row = sheet.getRow(0);
        cell = row.getCell(0);

    }

    public int getNumberOfDataUnderTitle(String title) {

        row = sheet.getRow(0);
        int NoOfColumns = row.getLastCellNum();
        int NoOfRows = sheet.getLastRowNum();

        for (int i=0 ; i<NoOfColumns ; i++){
            if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(title)){

                for(int j=1 ; j<=NoOfRows ; j++){

                    if(sheet.getRow(j).getCell(i) == null){
                        return j-1;
                    }
                }
                return NoOfRows;
            }
        }
        return 0;
    }

    public String getStringUnderTitle(String title, int index){
        row = sheet.getRow(0);
        int NoOfColumns = row.getLastCellNum();
        CellType type;

        String returnString = "";

        for (int i=0 ; i<NoOfColumns ; i++) {
            if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(title)) {
                type = sheet.getRow(index+1).getCell(i).getCellType();
                if(type.equals(CellType.STRING)){
                    returnString = sheet.getRow(index+1).getCell(i).getStringCellValue();
                }
                else if (type.equals(CellType.NUMERIC)){
                    sheet.getRow(index+1).getCell(i).setCellType(CellType.STRING);
                    returnString = sheet.getRow(index+1).getCell(i).getStringCellValue();
                }
                i=NoOfColumns;
            }
        }
        return returnString;
    }

}
