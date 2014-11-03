/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp;

/**
 * Utilities.
 *
 * @author jojorabbit4
 */
public class Utils {

    // == constructors ==
    private Utils() {
        // no-op
    }

    // == public methods ==
    /**
     * Rotates array by n positions.
     * Uses <code>System.arraycopy()</code> internally so it is not suitable for very big arrays.
     *
     * @param array     array to rotate.
     * @param positions no of positions to rotate.
     * @throws UnsupportedOperationException if array is null.
     * @return array rotated by n positions.
     */
    public static int[] rotate(int[] array, int positions) {
        if (array == null) {
            throw new UnsupportedOperationException("array must not be null");
        }

        int size = array.length;

        // copy array so we dont modify passed array.
        int[] newArray = new int[size];
        System.arraycopy(array, 0, newArray, 0, size);

        if (size == 0) {
            return newArray;
        }

        // if positions > size just dont rotate over again. e.g. pos= 7, size = 6, rotate only by 1.
        positions = positions % size;

        if (positions < 0) { // if negative add size so we always rotate to right
            positions += size;
        }
        // rotation
        for (int start = 0, moved = 0; moved != size; start++) {
            int element = array[start];
            int replacedElement;
            int i = start;
            do {
                i += positions;

                if (i >= size) {
                    i -= size; // reset size;
                }

                // swap elements
                replacedElement = newArray[i];
                newArray[i] = element;
                element = replacedElement;
                //
                moved++;
            } while (i != start);
        }

        return newArray;

    }
}
