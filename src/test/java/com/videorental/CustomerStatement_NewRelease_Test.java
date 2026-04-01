package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatement_NewRelease_Test {
    private final String CUSTOMER_NAME = "James";
    private final String MOVIE_NAME = "New Movie";

    @Test
    public void given_NewReleaseMovieFor1day_then_3원청구() {
        // given
        Customer c = TestFixture.createCustomer(CUSTOMER_NAME);
        Rental rental = TestFixture.newRent(MOVIE_NAME, 1);

        // when
        c.addRental(rental);
        

        // then
        assertThat(c.statement()).isEqualTo(
                "Rental Record for James\n" +
                        "\t3.0(New Movie)\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void given_NewReleaseMovieFor2day_then_6원청구_보너스포인트() {
        // given
        Customer c = TestFixture.createCustomer(CUSTOMER_NAME);
        Rental rental = TestFixture.newRent(MOVIE_NAME, 2);

        // when
        c.addRental(rental);
        

        // then
        assertThat(c.statement()).isEqualTo(
                "Rental Record for James\n" +
                        "\t6.0(New Movie)\n" +
                        "Amount owed is 6.0\n" +
                        "You earned 2 frequent renter pointers"
        );
    }

    @Test
    public void given_NewReleaseMovieFor7day_then_21원청구() {
        // given
        Customer c = TestFixture.createCustomer(CUSTOMER_NAME);
        Rental rental = TestFixture.newRent(MOVIE_NAME, 7);

        // when
        c.addRental(rental);
        

        // then
        assertThat(c.statement()).isEqualTo(
                "Rental Record for James\n" +
                        "\t21.0(New Movie)\n" +
                        "Amount owed is 21.0\n" +
                        "You earned 2 frequent renter pointers"
        );
    }
}
