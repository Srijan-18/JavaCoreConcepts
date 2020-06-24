package com.bridgelabz.javacore.services;

import com.bridgelabz.javacore.model.Users;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndGSONTester {
    private static final String CSV_FILE_PATH="F:\\Data\\users.csv";
    private static final String JSON_FILE_PATH="F:\\Data\\users.json";

    public static void main(String[] args) {
        try {
            Reader reader= Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CsvToBeanBuilder<Users> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(Users.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<Users> csvToBean=csvToBeanBuilder.build();
            List<Users> users=csvToBean.parse();
            Gson gson=new Gson();
            String json=gson.toJson(users);
            FileWriter fileWriter=new FileWriter(JSON_FILE_PATH);
            fileWriter.write(json);
            fileWriter.close();
            BufferedReader br=new BufferedReader(new FileReader(JSON_FILE_PATH));
            Users[] csvObj=gson.fromJson(br,Users[].class);
            List<Users> usersList= Arrays.asList(csvObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
