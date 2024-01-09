package org.mower.example.parser;

import org.mower.example.entities.*;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

import java.util.ArrayList;
import java.util.List;

public class DataFormatter {
    public static MowerPosition formatLineMower(final String lineMower) {
        final String[] elements = lineMower.split(MowerManagementErrorsUtilities.CHAINE_ESPACE);
        final Coordinates mowerCoordinates = new Coordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
        final MowerOrientation mowerOrientation = getOrientation(String.valueOf(elements[2].charAt(0)));
        return new MowerPosition(mowerCoordinates, mowerOrientation);
    }

    private static MowerOrientation getOrientation(final String orientation) {
        for (MowerOrientation mowerOrientation : MowerOrientation.values()) {
            if (mowerOrientation.getOrientationCode().equals(orientation)) {
                return mowerOrientation;
            }
        }
        return null;
    }

    public static LawnCoordinates formatLineLawn(final String lineLawn) {
        final String[] elements = lineLawn.split(MowerManagementErrorsUtilities.CHAINE_ESPACE);
        return new LawnCoordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
    }

    public static List<MowerInstruction> formatterLineInstruction(final String instructionLine) {
        List<MowerInstruction> listInstruction = new ArrayList<MowerInstruction>();
        for (char instruction : instructionLine.toCharArray()) {
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    private static MowerInstruction getInstruction(final char instructionLine) {
        for (MowerInstruction instruction : MowerInstruction.values()) {
            if (instruction.getInstructionCode().equals(String.valueOf(instructionLine))) {
                return instruction;
            }
        }
        return null;
    }
}
