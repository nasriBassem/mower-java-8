package org.mower.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity class of mower coordinates
 *
 * @author bassem
 */
@Data
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;

    /**
     * Check if the coordinates of the mower after movement are outside those of the lawn
     *
     * @return true if coordinates is OK
     */
    public boolean isHorsCoordinatesMax(final Coordinates coordinatesMax) {
        return coordinatesMax.getX() >= 0
                && coordinatesMax.getY() >= 0
                && (coordinatesMax.getX() < this.x || coordinatesMax.getY() < this.y);
    }
}
