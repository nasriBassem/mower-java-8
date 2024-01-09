package org.mower.example.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MowerPositionTest {
    @Test
    public void compareEqualPositionOK() {
        MowerPosition positionT = new MowerPosition(new Coordinates(5, 5), MowerOrientationEnum.NORTH);
        MowerPosition positionTOk = new MowerPosition(new Coordinates(5, 5), MowerOrientationEnum.NORTH);
        assertEquals(positionT, positionTOk);
    }
    @Test
    public void compareEqualPositionTKoOrientation() {
        MowerPosition positionT = new MowerPosition(new Coordinates(5, 5), MowerOrientationEnum.NORTH);
        MowerPosition positionTKoOrientation = new MowerPosition(new Coordinates(5, 5), MowerOrientationEnum.SOUTH);
        assertNotEquals(positionT, positionTKoOrientation);
    }
    @Test
    public void compareEqualPositionTKoCoordinate() {
        MowerPosition positionT = new MowerPosition(new Coordinates(5, 5), MowerOrientationEnum.NORTH);
        MowerPosition positionTKoCoordinate = new MowerPosition(new Coordinates(5, 4), MowerOrientationEnum.SOUTH);
        assertNotEquals(positionT, positionTKoCoordinate);
    }
}
