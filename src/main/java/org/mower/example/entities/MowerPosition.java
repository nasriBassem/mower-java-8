package org.mower.example.entities;

import lombok.Data;

/**
 * Entity class of mower position
 *
 * @author bassem
 */
@Data
public class MowerPosition {
    private Coordinates mowerCoordinate;
    private MowerOrientation mowerOrientation;
}
