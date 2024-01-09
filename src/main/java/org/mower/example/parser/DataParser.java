package org.mower.example.parser;

import org.mower.example.entities.DataLineFile;
import org.mower.example.entities.MowerInstructionEnum;
import org.mower.example.entities.MowerOrientationEnum;

import static org.mower.example.utilities.MowerManagementErrorsUtilities.PATTERN_CORD;
import static org.mower.example.utilities.MowerManagementErrorsUtilities.SEPARATOR;

public class DataParser {
    public static boolean parseMower(final String mower) {
        String stringBuilder = MowerOrientationEnum.NORTH.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.SOUTH.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.EAST.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.WEST.getOrientationCode();
        return mower.matches("(\\d+) (\\d+) (" + stringBuilder + ")");
    }

    public static boolean parseInstructionsList(final String instructions) {
        String stringBuilder = "(" + MowerInstructionEnum.AVANCER.getInstructionCode() + SEPARATOR
                + MowerInstructionEnum.DROITE.getInstructionCode() +
                SEPARATOR + MowerInstructionEnum.GAUCHE.getInstructionCode() +
                ")+";
        return instructions.matches(stringBuilder);
    }

    public static boolean parseLawn(final String Lawn) {
        return Lawn.matches(PATTERN_CORD);
    }

    public static boolean executeParse(final DataLineFile dataLineFile) {
        return DataParser.parseMower(dataLineFile.getMower())
                && DataParser.parseLawn(dataLineFile.getLawn())
                && DataParser.parseInstructionsList(dataLineFile.getInstructions());
    }
}
