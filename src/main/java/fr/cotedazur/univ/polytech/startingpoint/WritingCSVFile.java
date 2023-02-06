package fr.cotedazur.univ.polytech.startingpoint;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.net.URL;
public class WritingCSVFile {
    public static void main(String[] args) throws Exception {
        URL fileUrl = WritingCSVFile.class.getClassLoader().getResource("gamestats.csv");

        CSVWriter writer = new CSVWriter(new FileWriter(fileUrl.getFile(), true));

        //Create record
        String[] record = new String[]{"","","","",""};

        //Write the record to file
        writer.writeNext(record, false);

        //close the writer
        writer.close();
    }
}
