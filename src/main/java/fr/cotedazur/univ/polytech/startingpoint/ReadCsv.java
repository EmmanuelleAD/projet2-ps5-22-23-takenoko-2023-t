package fr.cotedazur.univ.polytech.startingpoint;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
public class ReadCsv {
public static void readCsv() throws Exception {Path sourcePath= Path.of(" stats "," gamestats.csv ");
    //Build reader instance
    //Read data.csv
    //Default separator is comma
    //Start reading from line number 2 (line numbers start from zero)
    CSVParser csvParser = new CSVParserBuilder()
            .withSeparator(',')
            .withIgnoreQuotations(true)                .build();
    CSVReader csvReader = new CSVReaderBuilder(new FileReader(sourcePath.toString()))
            //   .withSkipLines(1)
            .withCSVParser(csvParser)
            .build();
    //Read CSV line by line and use the string array as you want
    String[] nextLine;
    while ((nextLine = csvReader.readNext()) != null) {
        if (nextLine != null) {
            //Verifying the read data here
            System.out.println(Arrays.asList(nextLine));
        }
    }
}}