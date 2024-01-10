package org.mower.example.parser;

import org.mower.example.entities.DataLineFile;
import org.mower.example.entities.MowerInstructionEnum;
import org.mower.example.entities.MowerOrientationEnum;

import static org.mower.example.utilities.MowerManagementErrorsUtilities.PATTERN_CORD;
import static org.mower.example.utilities.MowerManagementErrorsUtilities.SEPARATOR;

public class DataParserChecker {
    public static boolean parseMowerCheck(final String mower) {
        String stringBuilder = MowerOrientationEnum.NORTH.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.SOUTH.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.EAST.getOrientationCode() +
                SEPARATOR + MowerOrientationEnum.WEST.getOrientationCode();
        return mower.matches("(\\d+) (\\d+) (" + stringBuilder + ")");
    }

    public static boolean parseInstructionsListCheck(final String instructions) {
        String stringBuilder = "(" + MowerInstructionEnum.AVANCER.getInstructionCode() + SEPARATOR
                + MowerInstructionEnum.DROITE.getInstructionCode() +
                SEPARATOR + MowerInstructionEnum.GAUCHE.getInstructionCode() +
                ")+";
        return instructions.matches(stringBuilder);
    }

    public static boolean parseLawnCheck(final String Lawn) {
        return Lawn.matches(PATTERN_CORD);
    }

    public static boolean executeParseCheck(final DataLineFile dataLineFile) {
        return DataParserChecker.parseMowerCheck(dataLineFile.getMower())
                && DataParserChecker.parseLawnCheck(dataLineFile.getLawn())
                && DataParserChecker.parseInstructionsListCheck(dataLineFile.getInstructions());
    }
}
