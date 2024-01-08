package org.mower.example.parser;

import org.mower.example.entities.Coordinates;
import org.mower.example.entities.LawnCoordinates;
import org.mower.example.entities.MowerOrientation;
import org.mower.example.entities.MowerPosition;

public class MowerFormatter {
    private static final String CHAINE_ESPACE = " ";

    public static MowerPosition formatLineMower(final String lineMower) {
        final String[] elements = lineMower.split(CHAINE_ESPACE);
        final Coordinates mowerCoordinates = new Coordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
        final MowerOrientation mowerOrientation = getOrientation(String.valueOf(elements[2].charAt(0)));
        return new MowerPosition(mowerCoordinates, mowerOrientation);
    }
    public static MowerOrientation getOrientation(final String orientation) {
        for (MowerOrientation mowerOrientation :MowerOrientation.values()) {
            if (mowerOrientation.getOrientationCode().equals(orientation)) {
                return mowerOrientation;
            }
        }
        return null;
    }
    public static LawnCoordinates formatLineLawn(final String lineLawn){
        final String[] elements = lineLawn.split(CHAINE_ESPACE);
        return new LawnCoordinates(new Coordinates(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])));
    }

}
