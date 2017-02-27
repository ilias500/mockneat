package com.mockneat.mock.interfaces;


import org.junit.Test;

import java.util.function.Function;

import static com.mockneat.mock.Constants.RAND;
import static java.util.Arrays.stream;

import static com.mockneat.mock.Constants.RANDS;
import static com.mockneat.mock.Constants.RU_CYCLES;
import static com.mockneat.mock.utils.LoopsUtils.loop;
import static org.junit.Assert.assertTrue;

/**
 * Created by andreinicolinciobanu on 13/02/2017.
 */
public class RandUnitMapFunct {
    @Test
    public void testMapToIntInts() {
        loop(RU_CYCLES, () ->
                stream(RANDS).forEach(r ->
                    r.ints()
                        .range(0, 5)
                        .mapToInt(x -> x + 5)
                        .intStream().val()
                        .limit(10)
                        .forEach(x -> assertTrue(x >= 5 && x < 10))));
    }

    @Test(expected = NullPointerException.class)
    public void testMapToIntsNullFunct() {
        RAND.ints().range(0, 5).mapToInt(null).val();
    }

    @Test
    public void testMapToLong() {
        loop(RU_CYCLES, () ->
            stream(RANDS).forEach(r ->
                    r.longs()
                        .range(0, 5)
                        .mapToLong(x -> x +5)
                        .longStream().val()
                        .limit(10)
                        .forEach(x -> assertTrue(x >= 5l && x < 10l))));
    }

    @Test(expected = NullPointerException.class)
    public void testMapToLongNullFunct() {
        RAND.longs().range(0l, 5l).mapToLong(null).val();
    }

    @Test
    public void testMapToDoubleDoubles() {
        loop(RU_CYCLES, () ->
            stream(RANDS).forEach( r ->
                        r.doubles()
                            .range(0.5, 5.0)
                            .mapToDouble(x -> x + 5.0)
                            .doubleStream().val()
                            .limit(10)
                            .forEach(x -> assertTrue(x >= 5.0 && x < 10.0))));
    }

    @Test(expected = NullPointerException.class)
    public void testMapToDoubleNullFunct() {
        RAND.doubles().range(0.5, 10.0).mapToDouble(null).val();
    }

    @Test(expected = NullPointerException.class)
    public void testMapNullFunct() {
        RAND.ints().from(new int[]{ 5, 7, 8}).map(null).val();
    }

    @Test
    public void testMap() {
        Function<Object, String> f = (x) -> x.toString() + "x";
        MockUnit r = RAND.ints().from(new int[]{5});
        int i = 100;
        while(i-->0) r = r.map(f);
        String result = r.valStr();
        for(int j = 1; j < result.length(); ++j) {
            assertTrue(result.charAt(j)=='x');
        }
    }

    @Test(expected = NullPointerException.class)
    public void testMapFunct() {
        RAND.ints().from(new int[]{5}).map(null).val();
    }
}