package fr.cotedazur.univ.polytech.startingpoint;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Path;

public class Writing {
    public static void appendCsv(String texte) throws Exception {
        Path source= Path.of("stats","gamestats.csv");
        CSVWriter writer = new CSVWriter(new FileWriter(source.toString(),true));
        //Create record
        String[] record = texte.split("\n");

        //Write the record to file
        writer.writeNext(record, false);

        //close the writer
        writer.close();
    }
    public static void readCsv ( String source ) {

    }
    public static void main(String[]args) throws Exception {
        appendCsv(" nombre\n nombre ");
    }
}
