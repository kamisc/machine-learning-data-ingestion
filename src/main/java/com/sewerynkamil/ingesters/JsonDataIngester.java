package com.sewerynkamil.ingesters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sewerynkamil.model.SaleTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataIngester {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new JsonMapper();
        List<SaleTransaction> saleTransactionList = null;

        try {
            saleTransactionList = objectMapper.readValue(new File("example-data/sales-jp.xml"), new TypeReference<List<SaleTransaction>>() {});
            for (SaleTransaction transaction : saleTransactionList) {
                System.out.println(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
