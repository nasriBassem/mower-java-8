package org.mower.example.entities;

import lombok.Data;

import java.util.List;

@Data
public class MowerTreatment {
    private LawnCoordinates maxMowerPosition;
    private MowerPosition  actualMowerPosition;
    private List<MowerInstructionEnum> instructionList;
    public String toString(){
        return 	actualMowerPosition.getMowerCoordinate().getX()
                + " "
                + actualMowerPosition.getMowerCoordinate().getY()
                + " "
                + actualMowerPosition.getMowerOrientationEnum().getOrientationCode();
    }
}
