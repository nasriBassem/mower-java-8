package org.mower.example.services;

import org.mower.example.entities.*;
import org.mower.example.exception.MowerException;
import org.mower.example.utilities.MowerManagementErrorsUtilities;

/**
 * Service class to execute instruction
 *
 * @author bassem
 */
public class MowerExecuteInstructionService {

    private MowerExecuteInstructionService() {
    }
    /**
     * Edit mower orientation executing a move instruction
     *
     * @return mowerOrientation after edit
     *
     * @throws MowerException ORIENTATION_INCORRECT_ERROR
     */
    protected static MowerOrientationEnum moveLeftRightInstruction(final MowerInstructionEnum mowerInstruction, final MowerOrientationEnum oldMowerOrientation) throws MowerException {
        MowerOrientationEnum nextMowerOrientation;
        switch (oldMowerOrientation) {
            case NORTH:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.EAST : MowerOrientationEnum.WEST;
                break;
            case EAST:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.SOUTH : MowerOrientationEnum.NORTH;
                break;
            case SOUTH:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.WEST : MowerOrientationEnum.EAST;
                break;
            case WEST:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstructionEnum.DROITE.getInstructionCode()) ? MowerOrientationEnum.NORTH : MowerOrientationEnum.SOUTH;
                break;
            default:
                throw new MowerException(MowerManagementErrorsUtilities.ORIENTATION_INCORRECT_ERROR);
        }
        return nextMowerOrientation;
    }

    /**
     * Edit mower coordinate executing a move forward instruction
     *
     * @return MowerCoordinates
     * @throws MowerException POSITION_INCORRECT_ERROR
     */
    protected static Coordinates moveForwardInstruction(final MowerPosition mowerPosition, final LawnCoordinates maxMowerPosition) throws MowerException {
        int x;
        int y;
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
        final Coordinates newCoordinates = new Coordinates(x, y);
        return newCoordinates.isInCoordinatesMax(maxMowerPosition) ? newCoordinates : mowerPosition.getMowerCoordinate();
    }

    protected static void executeInstructions(final MowerTreatment treatmentMower) throws MowerException {
        for (MowerInstructionEnum instruction : treatmentMower.getInstructionList()) {
            treatmentMower.setActualMowerPosition(executeInstruction(instruction, treatmentMower.getActualMowerPosition(),treatmentMower.getMaxMowerPosition()));
        }
    }

    /**
     * Execute Instruction
     *
     * @throws MowerException INSTRUCTION_INCORRECT_ERROR
     */
    protected static MowerPosition executeInstruction(MowerInstructionEnum instruction, MowerPosition mowerPosition,LawnCoordinates maxMowerPosition) throws MowerException {
        switch (instruction) {
            case GAUCHE:
            case DROITE:
                mowerPosition.setMowerOrientationEnum(moveLeftRightInstruction(instruction, mowerPosition.getMowerOrientationEnum()));
                break;
            case AVANCER:
                mowerPosition.setMowerCoordinate(moveForwardInstruction(mowerPosition,maxMowerPosition));
                break;
            default:
                throw new MowerException(MowerManagementErrorsUtilities.INSTRUCTION_INCORRECT_ERROR);
        }
        return mowerPosition;
    }
}
