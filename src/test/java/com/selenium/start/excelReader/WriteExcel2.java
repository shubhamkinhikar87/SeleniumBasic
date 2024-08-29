package com.selenium.start.excelReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcel2 {
    public static void main(String[] args) throws IOException {
        Map<String, Object> map= new TreeMap<>();
        map.put("1", new Object[]{"id","email","password"});
        map.put("2", new Object[]{"1","skinhikar@gmail.com","test809"});
        map.put("3", new Object[]{"2","prawale@gmail.com","temp@123"});
        map.put("4", new Object[]{"3","premRawale@yahoo.com","password234"});

        Set<String> keyset= map.keySet();
        int rownum=0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet =workbook.createSheet("Main");
        for(String key:keyset){
            Row row =sheet.createRow(rownum++);
            Object[] object= (Object[]) map.get(key);
            int cellNum=0;
            for(Object data: object){
                Cell cell =row.createCell(cellNum++);
                cell.setCellValue((String) data);
            }

        }
        FileOutputStream fileOutputStream=new FileOutputStream("WriteExcel2.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();



    }

}
