package org.mower.example.entities;

import org.junit.Test;
import org.mower.example.parser.DataParserChecker;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class DataLineFileTest {
    @Test
    public void compareEqualDataLineFileOK() {
        assertEquals(parseDataLineFile("DGDGA", "50 5", "1 2 N"), parseDataLineFile("DGDGA", "50 5", "1 2 N"));
    }

    @Test
    public void compareEqualDataLineFileKOInstruction() {
        assertNotEquals(parseDataLineFile("DGDGA", "50 5", "1 2 N"), parseDataLineFile("DGAGA", "50 5", "1 2 N"));
    }

    @Test
    public void compareEqualDataLineFileKOLawn() {
        assertNotEquals(parseDataLineFile("DGDGA", "50 5", "1 2 N"), parseDataLineFile("DGDGA", "50 4", "1 2 N"));
    }

    @Test
    public void compareEqualDataLineFileKOMower() {
        assertNotEquals(parseDataLineFile("DGDGA", "50 5", "1 2 N"), parseDataLineFile("DGDGA", "50 5", "1 2 S"));
    }

    @Test
    public void executeParseDataLineFileOK() {
        assertTrue(DataParserChecker.executeParseCheck(parseDataLineFile("DGDGA", "50 5", "1 2 N")));
    }

    @Test
    public void executeParseDataLineFileKOInstruction() {
        assertFalse(DataParserChecker.executeParseCheck(parseDataLineFile("DGDGB", "50 5", "1 2 N")));
    }

    @Test
    public void executeParseDataLineFileKOLawn() {
        assertFalse(DataParserChecker.executeParseCheck(parseDataLineFile("DGDGA", "50 A", "1 2 N")));
    }

    @Test
    public void executeParseDataLineFileKOMower() {
        assertFalse(DataParserChecker.executeParseCheck(parseDataLineFile("DGDGA", "50 5", "1 2 Z")));
    }

    private DataLineFile parseDataLineFile(final String instructions, final String lawn, final String mower) {
        final DataLineFile dataLineFile = new DataLineFile();
        dataLineFile.setInstructions(instructions);
        dataLineFile.setLawn(lawn);
        dataLineFile.setMower(mower);
        return dataLineFile;
    }
}
