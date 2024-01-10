package org.mower.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All possibles directions
 *
 * @author bassem
 */
@Getter
@AllArgsConstructor
public enum MowerOrientationEnum {
    NORTH("N", "North"),
    EAST("E", "East"),
    WEST("W", "West"),
    SOUTH("S", "South"),
    UNDEFINED("","");

    private final String orientationCode;
    private final String orientationLabel;
}
