package org.mower.example;

import org.junit.Test;
import org.mower.example.exception.MowerException;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

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

    @Test
    public void runProgramMainFileNOTFound() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.NOT_FOUND_FILE_ERROR);
        RunProgram.main("FileNOTFound");
    }

    @Test
    public void runProgramMainErrorFirstLine() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + "fileLine1.txt");
    }

    @Test
    public void runProgramMainErrorSecondLine() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + "fileLine2.txt");
    }

    @Test
    public void runProgramMainErrorOnlyTwoLines() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + "missingLineFile.txt");

    }
    @Test
    public void runProgramMainErrorEmptyFile() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + "emptyFile.txt");
    }
    @Test
    public void runProgramMainKO() throws MowerException, IOException {
        expectedEx.expect(MowerException.class);
        expectedEx.expectMessage(MowerManagementErrorsUtilities.INCORRECT_DATA_ERROR);
        RunProgram.main(CHEMIN_FICHIER + "fileKO.txt");
    }
    @Test
     public void runProgramMainOK() throws MowerException, IOException {
        RunProgram.main(CHEMIN_FICHIER + "fileOK.txt");
        assertNotNull(listResults);
        assertEquals(listResults.size(), 2);
        assertTrue(RunProgram.listResults.contains("1 3 N"));
        assertTrue(RunProgram.listResults.contains("5 1 E"));
    }
}
