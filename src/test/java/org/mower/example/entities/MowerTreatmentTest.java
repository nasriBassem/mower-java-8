package org.mower.example.entities;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MowerTreatmentTest {

   @Test
    public void compareEqualMowerTreatmentOK(){
        MowerTreatment mowerTreatment = new MowerTreatment();
        LawnCoordinates coordinates = new LawnCoordinates(5, 5);
        MowerPosition mowerPosition = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
        List<MowerInstructionEnum> instructionList = new ArrayList<>();
        instructionList.add(MowerInstructionEnum.DROITE);
        instructionList.add(MowerInstructionEnum.GAUCHE);
        mowerTreatment.setInstructionList (instructionList);
        mowerTreatment.setActualMowerPosition(mowerPosition);
        mowerTreatment.setMaxMowerPosition(coordinates);

       MowerTreatment mowerTreatment2 = new MowerTreatment();
       LawnCoordinates coordinates2 = new LawnCoordinates(5, 5);
       MowerPosition mowerPosition2 = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
       List<MowerInstructionEnum> instructionList2 = new ArrayList<>();
       instructionList2.add(MowerInstructionEnum.DROITE);
       instructionList2.add(MowerInstructionEnum.GAUCHE);
       mowerTreatment2.setInstructionList (instructionList2);
       mowerTreatment2.setActualMowerPosition(mowerPosition2);
       mowerTreatment2.setMaxMowerPosition(coordinates2);

       assertEquals(mowerTreatment, mowerTreatment2);
   }

    @Test
    public void compareEqualMowerTreatmentKO(){
        MowerTreatment mowerTreatment = new MowerTreatment();
        LawnCoordinates coordinates = new LawnCoordinates(5, 5);
        MowerPosition mowerPosition = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
        List<MowerInstructionEnum> instructionList = new ArrayList<>();
        instructionList.add(MowerInstructionEnum.DROITE);
        instructionList.add(MowerInstructionEnum.GAUCHE);
        mowerTreatment.setInstructionList (instructionList);
        mowerTreatment.setActualMowerPosition(mowerPosition);
        mowerTreatment.setMaxMowerPosition(coordinates);

        MowerTreatment mowerTreatment2 = new MowerTreatment();
        LawnCoordinates coordinates2 = new LawnCoordinates(5, 5);
        MowerPosition mowerPosition2 = new MowerPosition(new Coordinates(1, 2), MowerOrientationEnum.NORTH);
        List<MowerInstructionEnum> instructionList2 = new ArrayList<>();
        instructionList2.add(MowerInstructionEnum.GAUCHE);
        instructionList2.add(MowerInstructionEnum.DROITE);
        mowerTreatment2.setInstructionList (instructionList2);
        mowerTreatment2.setActualMowerPosition(mowerPosition2);
        mowerTreatment2.setMaxMowerPosition(coordinates2);

        assertNotEquals(mowerTreatment, mowerTreatment2);
    }
}
