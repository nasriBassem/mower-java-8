package org.mower.example.entities;

import org.junit.Test;
import org.mower.example.parser.DataParserChecker;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class DataLineFileTest {
    @Test
    public void compareEqualDataLineFileOK() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");

        DataLineFile dataLineFile2 = new DataLineFile();
        dataLineFile2.setInstructions("DGDGA");
        dataLineFile2.setLawn("50 5");
        dataLineFile2.setMower("1 2 N");

        assertEquals(dataLineFile, dataLineFile2);
    }

    @Test
    public void compareEqualDataLineFileKOInstruction() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");

        DataLineFile dataLineFile2 = new DataLineFile();
        dataLineFile2.setInstructions("DGAGA");
        dataLineFile2.setLawn("50 5");
        dataLineFile2.setMower("1 2 N");

        assertNotEquals(dataLineFile, dataLineFile2);
    }

    @Test
    public void compareEqualDataLineFileKOLawn() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");

        DataLineFile dataLineFile2 = new DataLineFile();
        dataLineFile2.setInstructions("DGDGA");
        dataLineFile2.setLawn("50 4");
        dataLineFile2.setMower("1 2 N");

        assertNotEquals(dataLineFile, dataLineFile2);
    }

    @Test
    public void compareEqualDataLineFileKOMower() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");

        DataLineFile dataLineFile2 = new DataLineFile();
        dataLineFile2.setInstructions("DGDGA");
        dataLineFile2.setLawn("50 5");
        dataLineFile2.setMower("1 2 S");

        assertNotEquals(dataLineFile, dataLineFile2);
    }


    @Test
    public void executeParseDataLineFileOK() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");
        assertTrue(DataParserChecker.executeParseCheck(dataLineFile));
    }

    @Test
    public void executeParseDataLineFileKOInstruction() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGB");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 N");
        assertFalse(DataParserChecker.executeParseCheck(dataLineFile));
    }

    @Test
    public void executeParseDataLineFileKOLawn() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 A");
        dataLineFile.setMower("1 2 N");
        assertFalse(DataParserChecker.executeParseCheck(dataLineFile));
    }
    @Test
    public void executeParseDataLineFileKOMower() {
        DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions("DGDGA");
        dataLineFile.setLawn("50 5");
        dataLineFile.setMower("1 2 Z");
        assertFalse(DataParserChecker.executeParseCheck(dataLineFile));
    }
}
