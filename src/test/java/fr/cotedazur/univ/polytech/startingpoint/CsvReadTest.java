package fr.cotedazur.univ.polytech.startingpoint;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.File;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;

public class CsvReadTest {
    private ReadCsv readCsv;
    private Path sourcePath;

    @Before
    public void setUp() {
        readCsv = new ReadCsv();
        sourcePath = Path.of("stats", "gamestats.csv");
    }



    @Test(expected = Exception.class)
    public void testReadCsvFileNotFoundException() throws Exception {
        sourcePath = Path.of("stats", "invalidFile.csv");
        readCsv.readCsv();
    }


    @Test
    public void testReadCsvWithInvalidCsvFile() throws Exception {
        File csvFile = new File("stats/invalidGamestats.csv");
        assertThrows(Exception.class, () -> ReadCsv.readCsv());
    }


    @Test
    public void testReadCsvWithInvalidFilePath() throws Exception {
        assertThrows(Exception.class, () -> ReadCsv.readCsv());
    }






}

