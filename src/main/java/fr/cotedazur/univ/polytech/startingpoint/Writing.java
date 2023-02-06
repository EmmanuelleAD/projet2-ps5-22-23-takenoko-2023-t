package fr.cotedazur.univ.polytech.startingpoint;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.net.URL;

public class Writing {
    public static void main(String[] args) throws Exception {
        URL fileUrl = WritingCSVFile.class.getClassLoader().getResource("gamestats.csv");

        CSVWriter writer = new CSVWriter(new FileWriter(fileUrl.getFile()));

        //Create record
        String[] record = "".split(",");

        //Write the record to file
        writer.writeNext(record, false);

        //close the writer
        writer.close();
    }
}
