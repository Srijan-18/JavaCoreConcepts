package com.bridgelabz.javacore;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromCSVFile {
    private static final String CSV_FILE_PATH = "F:\\Data\\users.csv";

    public static void main(String[] args) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()
        ) {
            //Reading Records One by One In String Array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name :" + nextRecord[1]);
                System.out.println("Email :" + nextRecord[0]);
                System.out.println("Phone :" + nextRecord[2]);
                System.out.println("\n******");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
