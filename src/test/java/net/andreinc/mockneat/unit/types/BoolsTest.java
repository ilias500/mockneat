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

import org.junit.Test;

import static net.andreinc.mockneat.Constants.*;
import static net.andreinc.mockneat.utils.LoopsUtils.loop;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoolsTest {

    @Test
    public void test100ProbabilityVal() throws Exception {
        loop(BOOLS_CYCLES,
                MOCKS,
                r -> r.bools().probability(100.0).val(),
                b -> assertTrue(b));
    }

    @Test
    public void testNextBooleanAlwaysFalseIf() throws Exception {
        loop(BOOLS_CYCLES,
                MOCKS,
                r -> r.bools().probability(0.0).val(),
                bol -> assertFalse(bol));
    }

    @Test
    public void testNextBooleanAlwaysFalseIf02() throws Exception {
        loop(BOOLS_CYCLES,
                MOCKS,
                rand -> rand.bools().probability(0.0).val(),
                bol -> assertFalse(bol));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextBooleanNegativeNotProbability() throws Exception {
        M.bools().probability(-5.0).val();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextBooleanNegativeNotProbability_2() throws Exception {
        M.bools().probability(-5.0).val();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextBooleanGreaterThan100NotProbability() throws Exception {
        M.bools().probability(105.0).val();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextBooleanGreaterThan100NotProbability2() throws Exception {
        M.bools().probability(105.0).val();
    }

    @Test
    public void testBools() throws Exception {
        loop(BOOLS_CYCLES,
                MOCKS,
                r -> r.bools().val(),
                b -> assertTrue(b!=null && (b||!b)));
    }
}
