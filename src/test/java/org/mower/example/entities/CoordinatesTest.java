package org.mower.example.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {
    @Test
    public void compareEqualCoordinatesOK() {
        Coordinates coordinates1 = new Coordinates(1, 2);
        Coordinates coordinates2 = new Coordinates(1, 2);
        assertEquals(coordinates1, coordinates2);
    }
    @Test
    public void compareEqualCoordinatesKOX() {
        Coordinates coordinates1 = new Coordinates(1, 2);
        Coordinates coordinates2 = new Coordinates(2, 2);
        assertNotEquals(coordinates1, coordinates2);
    }

    @Test
    public void compareEqualCoordinatesKOY() {
        Coordinates coordinates1 = new Coordinates(1, 2);
        Coordinates coordinates2 = new Coordinates(1, 3);
        assertNotEquals(coordinates1, coordinates2);
    }

    @Test
    public void checkIfOutsideCoordinatesMaxOK(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(5,5);
        Coordinates c0 = new Coordinates(-1,1);
        assertFalse(lawCoordinates.checkIfOutsideCoordinatesMax(c0));
    }

    @Test
    public void checkIfOutsideCoordinatesMaxKO(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(5,5);
        Coordinates c1 = new Coordinates(1,1);
        assertTrue(lawCoordinates.checkIfOutsideCoordinatesMax(c1));
    }
}
