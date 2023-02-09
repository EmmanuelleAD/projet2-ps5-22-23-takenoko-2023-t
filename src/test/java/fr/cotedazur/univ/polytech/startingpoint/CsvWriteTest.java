package fr.cotedazur.univ.polytech.startingpoint;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class CsvWriteTest {

    @BeforeEach
    void setUp() {
        Object source = Path.of("stats", "gamestats.csv");
    }

    @Test
    void testAppendCsv() {
        assertDoesNotThrow(() -> Writing.appendCsv(" nombre\n nombre "));
    }
    @Test
    void testAppendCsvWithEmptyString() {
        assertDoesNotThrow(() -> Writing.appendCsv(""));
    }

    @Test
    public void testAppendCsvSuccess() throws Exception {
        File csvFile = new File("stats/gamestats.csv");
        Writing.appendCsv("number\nnumber");
        assertNotNull(csvFile);
    }




}
