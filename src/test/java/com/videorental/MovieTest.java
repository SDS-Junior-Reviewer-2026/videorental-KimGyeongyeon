package com.videorental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTest {
    private final String MOVIE_NAME = "The Latest Movie";
    private final int PRICE_CODE = 1;
    @Test
    public void MovieCreationTest() {
        Assertions.assertDoesNotThrow(() -> {
            new Movie(MOVIE_NAME, PRICE_CODE);
        });
    }

    @Test
    public void MovieSetPriceCodeTest() {
        Movie m = new Movie(MOVIE_NAME, PRICE_CODE);

        // when
        int NEW_PRICE_CODE = 2;
        m.setPriceCode(NEW_PRICE_CODE);

        Assertions.assertEquals(NEW_PRICE_CODE, m.getPriceCode());
    }
}
