package net.andreinc.mockneat.unit.types;

/**
 * Copyright 2017, Andrei N. Ciobanu

 Permission is hereby granted, free of charge, to any user obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, FREE_TEXT OF OR PARAM CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS PARAM THE SOFTWARE.
 */

import net.andreinc.mockneat.Constants;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static net.andreinc.mockneat.utils.LoopsUtils.loop;
import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.junit.Assert.assertTrue;

public class IntsTest {

    @Test
    public void testNextIntegerInCorrectRange() throws Exception {
        int upperBound = 100;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().bound(upperBound).val(),
                num -> assertTrue(num < 100 && num >= 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextIntegerNegativeNotBound() throws Exception {
        int upperBound = -100;
        Constants.M.ints().bound(upperBound).val();
    }

    @Test(expected = NullPointerException.class)
    public void testNextIntegerNullNotBound() throws Exception {
        Integer bound = null;
        Constants.M.ints().bound(bound).val();
    }

    @Test
    public void testNextIntegerInCorrectRange2() throws Exception {
        int upperBound = 1;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().bound(upperBound).val(),
                num -> assertTrue(num.equals(0)));
    }

    @Test
    public void testNextIntegerInCorrectRange3() throws Exception {
        Integer upperBound = Integer.MAX_VALUE;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().bound(upperBound).val(),
                num -> assertTrue(num < upperBound));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextIntegerNegativeNotBound2() throws Exception {
        int lowerBound = -1;
        int upperBound = 100;
        Constants.M.ints().range(lowerBound, upperBound).val();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextIntegerNegativeNotBound3() throws Exception {
        int lowerBound = 100;
        int upperBound = -5;
        Constants.M.ints().range(lowerBound, upperBound).val();
    }

    @Test(expected = NullPointerException.class)
    public void testNextIntegerNullNotBound2() throws Exception {
        Integer x = null;
        Constants.M.ints().range(x, 10).val();
    }

    @Test(expected = NullPointerException.class)
    public void testNextIntegerNullNotBound3() throws Exception {
        Integer x = null;
        Constants.M.ints().range(10, x).val();
    }

    @Test
    public void testNextIntegerInCorrectRange4() throws Exception {
        int lowerBound = 5;
        int upperBound = 8;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().range(lowerBound, upperBound).val(),
                num -> assertTrue((num >= lowerBound) && (num < upperBound)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextIntegerNonEqualBounds() throws Exception {
        int lowerBound = 10, upperBound = 10;
        Constants.M.ints().range(lowerBound, upperBound).val();
    }

    @Test
    public void testNextIntegerCorrectValues() throws Exception {
        int lowerBound = 10, upperBound = lowerBound + 1;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().range(lowerBound, upperBound).val(),
                num -> num.equals(lowerBound));
    }

    @Test
    public void testNextIntegerInCorrectRange5() throws Exception {
        int lowerBound = 0;
        int upperBound = Integer.MAX_VALUE;
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().range(lowerBound, upperBound).val(),
                num -> assertTrue(num >= lowerBound && num < upperBound));
    }

    @Test
    public void testNextCorrectValues() throws Exception {
        int[] alphabet = { 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
        Set<Integer> helperSet = new HashSet<>(asList(toObject(alphabet)));
        loop(Constants.INTS_CYCLES,
                Constants.MOCKS,
                r -> r.ints().from(alphabet).val(),
                num -> assertTrue(helperSet.contains(num)));
    }

    @Test(expected = NullPointerException.class)
    public void testNextNulLNotAlphabet() throws Exception {
        int[] alphabet = null;
        Constants.M.ints().from(alphabet).val();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextEmptyArrayNotAlphabet() throws Exception {
        int[] alphabet = new int[]{};
        Constants.M.ints().from(alphabet).val();
    }
}
