package com.selenium.start.excelReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream= new FileInputStream("ReadData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator= sheet.iterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator= row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell=cellIterator.next();
                if(cell.getCellType()== CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());
                }
                if (cell.getCellType()== CellType.STRING) {
                    System.out.println(cell.getStringCellValue());
                }
            }
        }


    }
}
