/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jojorabbit4
 */
public class UtilsTest {

    // == attributes ==
    private int[] array;

    // == init ==
    @Before
    public void init() {
        array = new int[]{1, 2, 3, 4, 5, 6};
    }

    // == test methods ==
    
    @Test(expected = UnsupportedOperationException.class)
    public void testRotateWithNullArray() {
        Utils.rotate(null, 0);
    }

    @Test
    public void testRotateEmptyArray() {
        int[] actuals = Utils.rotate(new int[]{}, 5);
        assertTrue(actuals.length == 0);
    }

    @Test
    public void testRotateArrayPositivePos() {
        int[] expecteds = new int[]{5, 6, 1, 2, 3, 4};
        int actuals[] = Utils.rotate(array, 2);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testRotateArrayNegativePos() {
        int[] expecteds = new int[]{5, 6, 1, 2, 3, 4};
        int[] actuals = Utils.rotate(array, -4);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testRotatePosMoreThenSize() {
        int[] expecteds = new int[]{5, 6, 1, 2, 3, 4};
        int[] actuals = Utils.rotate(array, 14);
        assertArrayEquals(expecteds, actuals);
    }
}
