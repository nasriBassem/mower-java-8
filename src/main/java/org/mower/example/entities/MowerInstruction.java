package org.mower.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All possibles instructions
 *
 * @author bassem
 */
@Getter
@AllArgsConstructor
public enum MowerInstruction {
    MOVE_RIGHT("R", "MOVE_RIGHT"),
    MOVE_LEFT("L", "MOVE_LEFT"),
    MOVE_FORWARD("F", "MOVE_FORWARD");

    private final String instructionCode;
    private final String instructionLabel;
}
