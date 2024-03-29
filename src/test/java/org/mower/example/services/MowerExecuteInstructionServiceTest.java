package org.mower.example.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mower.example.entities.*;
import org.mower.example.exception.MowerException;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import static org.junit.Assert.assertEquals;
import static org.mower.example.entities.MowerInstructionEnum.DROITE;
import static org.mower.example.entities.MowerInstructionEnum.GAUCHE;
import static org.mower.example.entities.MowerOrientationEnum.*;

public class MowerExecuteInstructionServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void moveRightInstructionOKNORTHToEAST() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(DROITE, NORTH);
        assertEquals(EAST, nextMowerOrientation);
    }
    @Test
    public void moveRightInstructionOKEASTToSOUTH() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(DROITE, EAST);
        assertEquals(SOUTH, nextMowerOrientation);
    }
    @Test
    public void moveRightInstructionOKWESTToNORTH() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(DROITE, WEST);
        assertEquals(NORTH, nextMowerOrientation);
    }
    @Test
    public void moveRightInstructionOKSOUTHtoWEST() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(DROITE, SOUTH);
        assertEquals(WEST, nextMowerOrientation);
    }
    @Test
    public void moveLeftInstructionOKNORTHToWEST() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(GAUCHE, NORTH);
        assertEquals(WEST, nextMowerOrientation);
    }
    @Test
    public void moveLeftInstructionOKEASTToNORTH() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(GAUCHE, EAST);
        assertEquals(NORTH, nextMowerOrientation);
    }
    @Test
    public void moveLeftInstructionOKWESTToSOUTH() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(GAUCHE, WEST);
        assertEquals(SOUTH, nextMowerOrientation);
    }
    @Test
    public void moveLeftInstructionOKSOUTHtoEAST() throws MowerException {
        final MowerOrientationEnum nextMowerOrientation = MowerExecuteInstructionService.moveLeftRightInstruction(GAUCHE, SOUTH);
        assertEquals(EAST, nextMowerOrientation);
    }
    @Test
    public void moveLeftInstructionOKNullException() throws MowerException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(MowerManagementErrorsUtilities.ORIENTATION_INCORRECT_ERROR);
        final MowerPosition mowerPosition = new MowerPosition(new Coordinates(1, 2),UNDEFINED);
        MowerExecuteInstructionService.moveLeftRightInstruction(GAUCHE, mowerPosition.getMowerOrientationEnum());
    }

    @Test
    public void moveForwardInstructionOutsideCoordinatesMaxOK() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(4, 5),NORTH);
        final Coordinates nextCoordinates = MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
        assertEquals(nextCoordinates, actualMowerPosition.getMowerCoordinate());
    }

    @Test
    public void moveForwardInstructionInsideCoordinatesMaxOKSOUTH() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),SOUTH);
        final Coordinates nextCoordinates = MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
        final Coordinates expectedCoordinates = new Coordinates(1, 1);
        assertEquals(expectedCoordinates, nextCoordinates);
    }
    @Test
    public void moveForwardInstructionInsideCoordinatesMaxOKNORTH() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),NORTH);
        final Coordinates nextCoordinates = MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
        assertEquals(nextCoordinates, new Coordinates(1, 3));
    }

    @Test
    public void moveForwardInstructionInsideCoordinatesMaxOKEAST() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),EAST);
        final Coordinates nextCoordinates = MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
        assertEquals(nextCoordinates, new Coordinates(2, 2));
    }

    @Test
    public void moveForwardInstructionInsideCoordinatesMaxOKWEST() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),WEST);
        final Coordinates nextCoordinates = MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
        assertEquals(nextCoordinates, new Coordinates(0, 2));
    }

    @Test
    public void moveForwardInstructionOKNullException() throws MowerException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(MowerManagementErrorsUtilities.POSITION_INCORRECT_ERROR);
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),UNDEFINED);
        MowerExecuteInstructionService.moveForwardInstruction(actualMowerPosition,maxMowerPosition);
    }

    @Test
    public void executeInstructionLeftOK() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),EAST);
        MowerExecuteInstructionService.executeInstruction(GAUCHE,actualMowerPosition,maxMowerPosition);
        assertEquals(NORTH, actualMowerPosition.getMowerOrientationEnum());
    }
    @Test
    public void executeInstructionRightOK() throws MowerException {
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),EAST);
        MowerExecuteInstructionService.executeInstruction(DROITE,actualMowerPosition,maxMowerPosition);
        assertEquals(SOUTH, actualMowerPosition.getMowerOrientationEnum());
    }

    @Test
    public void executeInstructionOKNullException() throws MowerException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(MowerManagementErrorsUtilities.INSTRUCTION_INCORRECT_ERROR);
        final LawnCoordinates maxMowerPosition = new LawnCoordinates(5, 5);
        final MowerPosition actualMowerPosition = new MowerPosition(new Coordinates(1, 2),EAST);
        MowerExecuteInstructionService.executeInstruction(MowerInstructionEnum.UNDEFINED,actualMowerPosition,maxMowerPosition);
    }
}
