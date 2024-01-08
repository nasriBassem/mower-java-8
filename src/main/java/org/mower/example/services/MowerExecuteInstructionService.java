package org.mower.example.services;

import lombok.NoArgsConstructor;
import org.mower.example.entities.Coordinates;
import org.mower.example.entities.MowerInstruction;
import org.mower.example.entities.MowerOrientation;
import org.mower.example.entities.MowerPosition;
import org.mower.example.exception.MowerException;
import org.mower.example.utilities.MowerManagementErrors;

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
    private MowerOrientation moveLeftRightInstruction(final MowerInstruction mowerInstruction, final MowerOrientation OldMowerOrientation) throws MowerException {
        MowerOrientation nextMowerOrientation;
        switch (OldMowerOrientation) {
            case NORTH:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstruction.MOVE_RIGHT.getInstructionCode()) ? MowerOrientation.EAST : MowerOrientation.WEST;
                break;
            case EAST:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstruction.MOVE_RIGHT.getInstructionCode()) ? MowerOrientation.SOUTH : MowerOrientation.NORTH;
                break;
            case SOUTH:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstruction.MOVE_RIGHT.getInstructionCode()) ? MowerOrientation.WEST : MowerOrientation.EAST;
                break;
            case WEST:
                nextMowerOrientation = mowerInstruction.getInstructionCode().equals(MowerInstruction.MOVE_RIGHT.getInstructionCode()) ? MowerOrientation.NORTH : MowerOrientation.SOUTH;
                break;
            default:
                throw new MowerException(MowerManagementErrors.ORIENTATION_INCORRECT_ERROR);
        }
        return nextMowerOrientation;
    }

    /**
     * Edit mower coordinate executing a move forward instruction
     *
     * @return MowerCoordinates
     * @throws MowerException POSITION_INCORRECT_ERROR
     */
    private Coordinates moveForwardInstruction(final MowerPosition mowerPosition) throws MowerException {
        int x, y;
        switch (mowerPosition.getMowerOrientation()) {
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
                throw new MowerException(MowerManagementErrors.POSITION_INCORRECT_ERROR);
        }
        final Coordinates nextCoordinates = new Coordinates(x, y);
        return nextCoordinates != null ? nextCoordinates : mowerPosition.getMowerCoordinate();
    }

    /**
     * Execute Instruction
     *
     * @throws MowerException INSTRUCTION_INCORRECT_ERROR
     */
    public void executeInstruction(final MowerInstruction mowerInstruction, final MowerPosition mowerPosition) throws MowerException {
        switch (mowerInstruction) {
            case MOVE_LEFT:
            case MOVE_RIGHT:
                mowerPosition.setMowerOrientation(moveLeftRightInstruction(mowerInstruction, mowerPosition.getMowerOrientation()));
                break;
            case MOVE_FORWARD:
                mowerPosition.setMowerCoordinate(moveForwardInstruction(mowerPosition));
                break;
            default:
                throw new MowerException(MowerManagementErrors.INSTRUCTION_INCORRECT_ERROR);
        }
    }
}