package org.mower.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity class of mower position
 *
 * @author bassem
 */
@Data
@AllArgsConstructor
public class MowerPosition {
    private Coordinates mowerCoordinate;
    private MowerOrientationEnum mowerOrientationEnum;
}
