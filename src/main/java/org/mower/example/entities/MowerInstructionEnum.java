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
public enum MowerInstructionEnum {
    DROITE("D", "Pivoter à droite"),
    GAUCHE("G", "Pivoter à gauche"),
    AVANCER("A", "Avancer");

    private final String instructionCode;
    private final String instructionLabel;
}
