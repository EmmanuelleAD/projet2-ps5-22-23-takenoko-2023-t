package fr.cotedazur.univ.polytech.startingpoint;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class Writing {
    public static void appendCsv(String texte) throws Exception {
        Path source= Path.of("stats","gamestats.csv");
        CSVWriter writer;
        try{
        writer= new CSVWriter(new FileWriter(source.toString(),true));
        }
        catch (Exception e){
            File file=new File("stats","gamestats.csv");
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
             writer = new CSVWriter(new FileWriter(source.toString(),true));

        }


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
        appendCsv("Est ce que j'y suis arrivé nombre\n nombre ");
    }
}
