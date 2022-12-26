package com.sewerynkamil.ingesters;

import com.sewerynkamil.model.SaleTransaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataIngester {
    public static SaleTransaction rowToSale(final Row row) {
        return new SaleTransaction.SaleTransactionBuilder()
                .uuid(row.getCell(0) != null ? row.getCell(0).getStringCellValue() : "")
                .timestamp(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "")
                .type(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "")
                .size(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "")
                .price(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "")
                .discount(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "")
                .offer(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "")
                .userId(row.getCell(7) != null ? (long) row.getCell(7).getNumericCellValue() : -1L)
                .build();
    }

    public static void main(String[] args) {
        String excelFilePath = "example-data/salesdata-ca.xlsx";

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(new File(excelFilePath)))) {
            Sheet firstSheet = workbook.getSheetAt(0);
            for (Row row : firstSheet) {
                if (row.getRowNum() == 0) continue;
                System.out.println(row);
                SaleTransaction transaction = rowToSale(row);
                System.out.println(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
