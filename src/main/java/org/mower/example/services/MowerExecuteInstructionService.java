package org.mower.example.services;

import lombok.NoArgsConstructor;
import org.mower.example.entities.*;
import org.mower.example.exception.MowerException;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

/**
 * Service class to execute instruction
 *
 * @author bassem
 */
@NoArgsConstructor
public class MowerExecuteInstructionService {
    /**
     * Edit mower orientation executing a move instruction
     *
     * @return mowerOrientation after edit
     * @throws MowerException ORIENTATION_INCORRECT_ERROR
     */
    private static MowerOrientationEnum moveLeftRightInstruction(final MowerInstructionEnum mowerInstructionEnum, final MowerOrientationEnum oldMowerOrientationEnum) throws MowerException {
        MowerOrientationEnum nextMowerOrientationEnum;
        switch (oldMowerOrientationEnum) {
            case NORTH:
                nextMowerOrientationEnum = mowerInstructionEnum.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.EAST : MowerOrientationEnum.WEST;
                break;
            case EAST:
                nextMowerOrientationEnum = mowerInstructionEnum.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.SOUTH : MowerOrientationEnum.NORTH;
                break;
            case SOUTH:
                nextMowerOrientationEnum = mowerInstructionEnum.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.WEST : MowerOrientationEnum.EAST;
                break;
            case WEST:
                nextMowerOrientationEnum = mowerInstructionEnum.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.NORTH : MowerOrientationEnum.SOUTH;
                break;
            default:
                throw new MowerException(MowerManagementErrorsUtilities.ORIENTATION_INCORRECT_ERROR);
        }
        return nextMowerOrientationEnum;
    }

    /**
     * Edit mower coordinate executing a move forward instruction
     *
     * @return MowerCoordinates
     * @throws MowerException POSITION_INCORRECT_ERROR
     */
    private static Coordinates moveForwardInstruction(final MowerPosition mowerPosition) throws MowerException {
        int x, y;
        switch (mowerPosition.getMowerOrientationEnum()) {
            case NORTH:
                x = mowerPosition.getMowerCoordinate().getX();
                y = mowerPosition.getMowerCoordinate().getY() + 1;
                break;
            case EAST:
                x = mowerPosition.getMowerCoordinate().getX() + 1;
                y = mowerPosition.getMowerCoordinate().getY();
                break;
            case SOUTH:
                x = mowerPosition.getMowerCoordinate().getX();
                y = mowerPosition.getMowerCoordinate().getY() - 1;
                break;
            case WEST:
                x = mowerPosition.getMowerCoordinate().getX() - 1;
                y = mowerPosition.getMowerCoordinate().getY();
                break;
            default:
                throw new MowerException(MowerManagementErrorsUtilities.POSITION_INCORRECT_ERROR);
        }
        final Coordinates nextCoordinates = new Coordinates(x, y);
        return nextCoordinates != null ? nextCoordinates : mowerPosition.getMowerCoordinate();
    }

    public static void executeInstructions(final MowerTreatment treatmentMower) throws MowerException{
        for(MowerInstructionEnum instruction : treatmentMower.getInstructionList()){
            executeInstruction(instruction, treatmentMower.getActualMowerPosition());
        }
    }
    /**
     * Execute Instruction
     *
     * @throws MowerException INSTRUCTION_INCORRECT_ERROR
     */
    private static void executeInstruction(final MowerInstructionEnum mowerInstructionEnum, final MowerPosition mowerPosition) throws MowerException {
        switch (mowerInstructionEnum) {
            case GAUCHE:
            case DROITE:
                mowerPosition.setMowerOrientationEnum(moveLeftRightInstruction(mowerInstructionEnum, mowerPosition.getMowerOrientationEnum()));
                break;
            case AVANCER:
                mowerPosition.setMowerCoordinate(moveForwardInstruction(mowerPosition));
                break;
            default:
                throw new MowerException(MowerManagementErrorsUtilities.INSTRUCTION_INCORRECT_ERROR);
        }
    }
}
