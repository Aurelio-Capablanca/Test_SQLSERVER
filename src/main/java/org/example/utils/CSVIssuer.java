package org.example.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CSVIssuer {

  public static void createDocument(String fileName, List<List<String>> dataset, List<String> tableHeader){
    CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(tableHeader.toArray(new String[0])).setDelimiter(';').setSkipHeaderRecord(false).build();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    String fileLocation = new StringBuilder().append(System.getProperty("user.home"))
            .append("\\Desktop\\")
            .append(fileName)
            .append(LocalDate.now().format(formatter))
            .append(".csv").toString();
    try(FileWriter writer = new FileWriter(fileLocation);
        CSVPrinter printer = new CSVPrinter(writer, format)
    ){
      for(List<String> row : dataset){
        printer.printRecord(row);
      }
      System.out.println("CSV file created successfully at " + fileLocation);
    } catch (IOException exception){
      exception.printStackTrace();
    }
  }

}
