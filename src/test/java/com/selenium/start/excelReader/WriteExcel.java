package com.selenium.start.excelReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("FirstSheet");

        Row row= sheet.createRow(1);
        row.createCell(1).setCellValue("Shubham");
        row.createCell(2).setCellValue("Rajandra");

        FileOutputStream fileOutputStream = new FileOutputStream("WriteData.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();



    }
}
