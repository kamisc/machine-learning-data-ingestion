package com.sewerynkamil.ingesters;

import com.sewerynkamil.model.SaleTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvDataIngester {
    public static SaleTransaction recordToSale(final CSVRecord record) {
        return new SaleTransaction.SaleTransactionBuilder()
                .uuid(record.get("txid"))
                .timestamp(record.get("txts"))
                .type(record.get("coffee"))
                .size(record.get("size"))
                .price(record.get("price"))
                .discount(record.get("discount"))
                .offer(record.get("offer"))
                .userId(Long.parseLong(record.get("userid")))
                .build();
    }

    public static void main(String[] args) {
        try (Reader in = new FileReader("example-data/salesdata-uk.csv")) {
            Iterable<CSVRecord> records = CSVFormat.Builder.create(CSVFormat.RFC4180)
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(in);
            for (CSVRecord record : records) {
                System.out.println(record);
                SaleTransaction saleTransaction = recordToSale(record);
                System.out.println(saleTransaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
