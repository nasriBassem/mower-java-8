package org.mower.example.parser;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataParserCheckerTest {
    @Test
    public void executeParseMowerCheckOk() {
       final String mower = "1 2 N";
        assertTrue(DataParserChecker.parseMowerCheck(mower));
    }
    @Test
    public void executeParseMowerCheckKo() {
        final String mower = "1 2 3 N";
        assertFalse(DataParserChecker.parseMowerCheck(mower));
    }
    @Test
    public void executeParseInstructionsListCheckOk() {
        final String instructions = "DGDGA";
        assertTrue(DataParserChecker.parseInstructionsListCheck(instructions));
    }
    @Test
    public void executeParseInstructionsListCheckKo() {
        final String instructions = "DGDGBA";
        assertFalse(DataParserChecker.parseInstructionsListCheck(instructions));
    }
    @Test
    public void executeParseILawnCheckOk() {
        final String lawn = "1 2";
        assertTrue(DataParserChecker.parseLawnCheck(lawn));
    }
    @Test
    public void executeParseILawnCheckKo() {
        final String lawn = "1 2 N";
        assertFalse(DataParserChecker.parseLawnCheck(lawn));
    }
}
