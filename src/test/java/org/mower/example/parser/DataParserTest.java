package org.mower.example.parser;

import org.junit.Test;
import org.mower.example.entities.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DataParserTest {

    @Test
    public void executeParseMowerLineOk() {
        final String mower = "1 2 N";
        MowerPosition mowerPositionExpected = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
        assertEquals(mowerPositionExpected , DataParser.parseLineMower(mower));
    }
    @Test
    public void executeParseMowerLineKoOrientation() {
        final String mower = "1 2 S";
        MowerPosition mowerPositionExpected = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
        assertNotEquals(mowerPositionExpected , DataParser.parseLineMower(mower));
    }
    @Test
    public void executeParseMowerLineKoCoordinates() {
        final String mower = "1 3 S";
        MowerPosition mowerPositionExpected = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.SOUTH);
        assertNotEquals(mowerPositionExpected , DataParser.parseLineMower(mower));
    }
    @Test
    public void executeGetOrientationOK() {
        String mowerOrientation = "N";
        assertEquals(MowerOrientationEnum.NORTH , DataParser.getOrientation(mowerOrientation));
        mowerOrientation = "S";
        assertEquals(MowerOrientationEnum.SOUTH , DataParser.getOrientation(mowerOrientation));
        mowerOrientation = "E";
        assertEquals(MowerOrientationEnum.EAST , DataParser.getOrientation(mowerOrientation));
        mowerOrientation = "W";
        assertEquals(MowerOrientationEnum.WEST , DataParser.getOrientation(mowerOrientation));
    }
    @Test
    public void executeGetOrientationKo() {
        String mowerOrientation = "N";
        assertNotEquals(MowerOrientationEnum.SOUTH , DataParser.getOrientation(mowerOrientation));
        mowerOrientation = "s";
        assertNotEquals(MowerOrientationEnum.SOUTH , DataParser.getOrientation(mowerOrientation));
    }
    @Test
    public void executeParseLawnLineOk() {
        final String lawn = "1 2";
        final LawnCoordinates lawnCoordinatesExpected = new LawnCoordinates(1, 2);
        assertEquals(lawnCoordinatesExpected , DataParser.parseLineLawn(lawn));
    }
    @Test
    public void executeParseLawnLineKo() {
        final String lawn = "1 3";
        final LawnCoordinates lawnCoordinatesExpected = new LawnCoordinates(1, 2);
        assertNotEquals(lawnCoordinatesExpected , DataParser.parseLineLawn(lawn));
    }

    @Test
    public void executeParseLineInstructionOk() {
        final String instructionLine = "DGDGA";
        final List<MowerInstructionEnum> instructionList = new ArrayList<>();
        instructionList.add(MowerInstructionEnum.DROITE);
        instructionList.add(MowerInstructionEnum.GAUCHE);
        instructionList.add(MowerInstructionEnum.DROITE);
        instructionList.add(MowerInstructionEnum.GAUCHE);
        instructionList.add(MowerInstructionEnum.AVANCER);
        assertEquals(instructionList , DataParser.parseLineInstruction(instructionLine));
    }
    @Test
    public void executeParseLineInstructionKONotOrder() {
        final String instructionLine = "DGDGA";
        final List<MowerInstructionEnum> instructionListNotOrder = new ArrayList<>();
        instructionListNotOrder.add(MowerInstructionEnum.GAUCHE);
        instructionListNotOrder.add(MowerInstructionEnum.DROITE);
        instructionListNotOrder.add(MowerInstructionEnum.DROITE);
        instructionListNotOrder.add(MowerInstructionEnum.GAUCHE);
        instructionListNotOrder.add(MowerInstructionEnum.AVANCER);
        assertNotEquals(instructionListNotOrder , DataParser.parseLineInstruction(instructionLine));
    }

    @Test
    public void executeParseLineInstructionKoNotSameInstructions() {
        final String instructionLine = "DGDGA";
        final List<MowerInstructionEnum> instructionListNotSameInstructions = new ArrayList<>();
        instructionListNotSameInstructions.add(MowerInstructionEnum.GAUCHE);
        instructionListNotSameInstructions.add(MowerInstructionEnum.DROITE);
        instructionListNotSameInstructions.add(MowerInstructionEnum.AVANCER);
        assertNotEquals(instructionListNotSameInstructions , DataParser.parseLineInstruction(instructionLine));
    }

    @Test
    public void executeGetInstructionOk() {
        char instruction = 'G';
        assertEquals(MowerInstructionEnum.GAUCHE , DataParser.getInstruction(instruction));
        instruction = 'D';
        assertEquals(MowerInstructionEnum.DROITE , DataParser.getInstruction(instruction));
        instruction = 'A';
        assertEquals(MowerInstructionEnum.AVANCER , DataParser.getInstruction(instruction));
    }

    @Test
    public void executeGetInstructionKoNotSame() {
        final char instruction = 'G';
        assertNotEquals(MowerInstructionEnum.DROITE , DataParser.getInstruction(instruction));
    }
    @Test
    public void executeGetInstructionKoNotCapitalLetter() {
        final char instruction = 'd';
        assertNotEquals(MowerInstructionEnum.DROITE , DataParser.getInstruction(instruction));
    }

}
