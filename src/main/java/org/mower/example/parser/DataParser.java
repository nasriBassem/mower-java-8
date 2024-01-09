package org.mower.example.parser;

import org.mower.example.entities.MowerInstruction;
import org.mower.example.entities.MowerOrientation;

import static org.mower.example.utilities.MowerManagementErrorsUtilities.PATTERN_CORD;
import static org.mower.example.utilities.MowerManagementErrorsUtilities.SEPARATOR;

public class DataParser {
    public static boolean parseMower(final String mower) {
        String stringBuilder = MowerOrientation.NORTH.getOrientationCode() +
                SEPARATOR + MowerOrientation.SOUTH.getOrientationCode() +
                SEPARATOR + MowerOrientation.EAST.getOrientationCode() +
                SEPARATOR + MowerOrientation.WEST.getOrientationCode();
        return mower.matches(PATTERN_CORD + "(" + stringBuilder + ")");
    }

    public static boolean parseInstructionsList(final String instructions) {
        String stringBuilder = "(" + MowerInstruction.MOVE_FORWARD.getInstructionCode() + SEPARATOR
                + MowerInstruction.MOVE_RIGHT.getInstructionCode() +
                SEPARATOR + MowerInstruction.MOVE_LEFT.getInstructionCode() +
                ")+";
        return instructions.matches(stringBuilder);
    }

    public static boolean parseLawn(final String Lawn) {
        return Lawn.matches(PATTERN_CORD);
    }

    public static boolean executeParse(final DataMapper dataMapper) {
        return DataParser.parseMower(dataMapper.getMower())
                && DataParser.parseLawn(dataMapper.getLawn())
                && DataParser.parseInstructionsList(dataMapper.getInstructions());
    }
}
