package org.mower.example.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {
    @Test
    public void verifier_surcharge_equals(){
        Coordinates c1 = new Coordinates(1, 2);
        Coordinates c2 = new Coordinates(1, 2);
        assertEquals(c1, c2);
        c2 = new Coordinates(1, 3);
        assertNotEquals(c1, c2);
    }
    @Test
    public void verifier_coordonnees_(){
        LawnCoordinates lawCoordinates = new LawnCoordinates(5,5);
        Coordinates c0 = new Coordinates(-1,1);
        Coordinates c1 = new Coordinates(1,1);
        assertFalse(lawCoordinates.checkIfOutsideCoordinatesMax(c0));
        assertTrue(lawCoordinates.checkIfOutsideCoordinatesMax(c1));
    }
}
