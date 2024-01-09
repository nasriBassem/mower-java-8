package org.mower.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LawnCoordinates extends Coordinates {
    public LawnCoordinates(int x, int y) {
        super(x, y);
    }
}
