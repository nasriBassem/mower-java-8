package org.mower.example.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LawnCoordinatesTest {
    @Test
    public void verifier_surcharge_equals() {
        LawnCoordinates lawCoordinates1 = new LawnCoordinates(1, 2);
        LawnCoordinates lawCoordinates2 = new LawnCoordinates(1, 2);
        assertEquals(lawCoordinates1, lawCoordinates2);
        LawnCoordinates lawCoordinates3 = new LawnCoordinates(1, 3);
        assertNotEquals(lawCoordinates1, lawCoordinates3);
    }
}
