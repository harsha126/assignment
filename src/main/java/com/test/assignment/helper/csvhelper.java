package com.test.assignment.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class csvhelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "code", "name", "batch", "stock","deal","free","mrp","rate","exp","company","supplier" };
    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }
    public static List<Input> csvToInputs(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Input> inputs = new ArrayList<Input>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Input input = new Input(
                        csvRecord.get("code"),
                        csvRecord.get("name"),
                        csvRecord.get("batch"),
                        Long.parseLong(csvRecord.get("stock")),
                        Long.parseLong(csvRecord.get("deal")),
                        Long.parseLong(csvRecord.get("free")),
                        Float.parseFloat(csvRecord.get("mrp")),
                        Float.parseFloat(csvRecord.get("rate")),
                        formatter.parse(csvRecord.get("exp")),
                        csvRecord.get("company"),
                        csvRecord.get("supplier")
                        );

                inputs.add(input);
            }

            return inputs;
        } catch (Exception e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
