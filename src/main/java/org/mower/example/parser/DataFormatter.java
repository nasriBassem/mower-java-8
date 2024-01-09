package org.mower.example.parser;

import org.mower.example.entities.*;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.util.ArrayList;
import java.util.List;

public class DataFormatter {
    public static MowerPosition formatLineMower(final String lineMower) {
        final String[] elements = lineMower.split(MowerManagementErrorsUtilities.CHAINE_ESPACE);
        final Coordinates mowerCoordinates = new Coordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
        final MowerOrientationEnum mowerOrientationEnum = getOrientation(String.valueOf(elements[2].charAt(0)));
        return new MowerPosition(mowerCoordinates, mowerOrientationEnum);
    }

    private static MowerOrientationEnum getOrientation(final String orientation) {
        for (MowerOrientationEnum mowerOrientationEnum : MowerOrientationEnum.values()) {
            if (mowerOrientationEnum.getOrientationCode().equals(orientation)) {
                return mowerOrientationEnum;
            }
        }
        return null;
    }

    public static LawnCoordinates formatLineLawn(final String lineLawn) {
        final String[] elements = lineLawn.split(MowerManagementErrorsUtilities.CHAINE_ESPACE);
        return new LawnCoordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
    }

    public static List<MowerInstructionEnum> formatterLineInstruction(final String instructionLine) {
        List<MowerInstructionEnum> listInstruction = new ArrayList<MowerInstructionEnum>();
        for (char instruction : instructionLine.toCharArray()) {
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    private static MowerInstructionEnum getInstruction(final char instructionLine) {
        for (MowerInstructionEnum instruction : MowerInstructionEnum.values()) {
            if (instruction.getInstructionCode().equals(String.valueOf(instructionLine))) {
                return instruction;
            }
        }
        return null;
    }
}
