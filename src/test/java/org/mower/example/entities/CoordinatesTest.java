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
    public void checkIfOutsideCoordinatesMaxOK_1(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(-1,-1);
        Coordinates c0 = new Coordinates(2,3);
        assertFalse(c0.isInCoordinatesMax(lawCoordinates));
    }
    @Test
    public void checkIfOutsideCoordinatesMaxOK_2(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(2,-1);
        Coordinates c0 = new Coordinates(3,3);
        assertFalse(c0.isInCoordinatesMax(lawCoordinates));
    }
    @Test
    public void checkIfOutsideCoordinatesMaxOK_3(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(2,3);
        Coordinates c0 = new Coordinates(3,3);
        assertFalse(c0.isInCoordinatesMax(lawCoordinates));
    }

    @Test
    public void checkIfOutsideCoordinatesMaxOK_4(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(3,2);
        Coordinates c0 = new Coordinates(3,3);
        assertFalse(c0.isInCoordinatesMax(lawCoordinates));
    }
      @Test
    public void checkIfOutsideCoordinatesMaxKO(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(5,5);
        Coordinates c1 = new Coordinates(1,1);
        assertTrue(c1.isInCoordinatesMax(lawCoordinates));
    }
}
