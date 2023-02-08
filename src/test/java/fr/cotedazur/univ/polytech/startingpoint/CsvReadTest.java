package fr.cotedazur.univ.polytech.startingpoint;

import static org.junit.Assert.assertArrayEquals;
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
}

