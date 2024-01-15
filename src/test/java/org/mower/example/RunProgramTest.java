package org.mower.example;

import org.junit.Test;
import org.mower.example.exception.MowerException;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mower.example.RunProgram.listResults;

public class RunProgramTest {

    final String CHEMIN_FICHIER = "./src/test/resources/";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void runProgramMainNumberArgsNotOK() throws MowerException, IOException {
        RunProgram.main("1", "2");
    }
    @Test(expected = IllegalArgumentException.class)
    public void runProgramMainNullArgsNotOK() throws MowerException, IOException {
        RunProgram.main(null);
    }

    @Test
    public void runProgramMainFileNOTFound() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.NOT_FOUND_FILE_ERROR);
        RunProgram.main("FileNOTFound");
    }

    @Test
    public void runProgramMainErrorFirstLine() throws MowerException, IOException {
        runProgramMainFile( "fileLine1.txt");
    }

    @Test
    public void runProgramMainErrorSecondLine() throws MowerException, IOException {
        runProgramMainFile( "fileLine2.txt");
    }
    @Test
    public void runProgramMainErrorOnlyTwoLines() throws MowerException, IOException {
        runProgramMainFile( "missingLineFile.txt");
    }
    @Test
    public void runProgramMainErrorEmptyFile() throws MowerException, IOException {
        runProgramMainFile( "emptyFile.txt");
    }
    @Test
    public void runProgramMainKO() throws MowerException, IOException {
        runProgramMainFile( "fileKO.txt");
    }
    @Test
     public void runProgramMainOK() throws MowerException, IOException {
        RunProgram.main(CHEMIN_FICHIER + "fileOK.txt");
        assertNotNull(listResults);
        assertEquals(2, listResults.size());
        assertTrue(RunProgram.listResults.contains("1 3 N"));
        assertTrue(RunProgram.listResults.contains("5 1 E"));
    }
    private void runProgramMainFile(final String fileName) throws MowerException, FileNotFoundException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + fileName);
    }
}
