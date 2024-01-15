package org.mower.example;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mower.example.exception.MowerException;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class Steps {
    final String CHEMIN_FICHIER = "./src/test/resources/org/mower/example/acceptance/";
    String filePath = "";
    @Given("File path :  \"$path\"")
    public void getFilePath(final String path) {
        filePath = CHEMIN_FICHIER + path;
    }
    @When("mow it now")
    public void mowitnow() throws MowerException, FileNotFoundException {
        RunProgram.main(filePath);
    }
    @Then("The mower $index must be positioned at ($x, $y) and oriented towards $orientation")
    public void verify(final int index, final int x, final int y, final String orientation) {
        assertNotNull(RunProgram.listResults);
        final String result = RunProgram.listResults.get(index-1);
        assertNotNull(result);
        assertTrue(RunProgram.listResults.contains("1 3 N"));
        assertTrue(RunProgram.listResults.contains("5 1 E"));
        assertEquals(result, x +" "+ y +" "+orientation);
    }
}
