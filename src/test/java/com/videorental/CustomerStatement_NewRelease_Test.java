package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatement_NewRelease_Test {
    @Test
    public void given_NewReleaseMovieFor1day_then_3원청구() {
        // given
        Customer c = TestFixture.createCustomer("James");
        Rental rental = TestFixture.newRent("New Movie", 1);

        // when
        c.addRental(rental);
        String stmt = c.statement();

        // then
        assertThat(stmt).isEqualTo(
                "Rental Record for James\n" +
                        "\t3.0(New Movie)\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void given_NewReleaseMovieFor2day_then_6원청구_보너스포인트() {
        // given
        Customer c = TestFixture.createCustomer("James");
        Rental rental = TestFixture.newRent("New Movie", 2);

        // when
        c.addRental(rental);
        String stmt = c.statement();

        // then
        assertThat(stmt).isEqualTo(
                "Rental Record for James\n" +
                        "\t6.0(New Movie)\n" +
                        "Amount owed is 6.0\n" +
                        "You earned 2 frequent renter pointers"
        );
    }

    @Test
    public void given_NewReleaseMovieFor7day_then_21원청구() {
        // given
        Customer c = TestFixture.createCustomer("James");
        Rental rental = TestFixture.newRent("New Movie", 7);

        // when
        c.addRental(rental);
        String stmt = c.statement();

        // then
        assertThat(stmt).isEqualTo(
                "Rental Record for James\n" +
                        "\t21.0(New Movie)\n" +
                        "Amount owed is 21.0\n" +
                        "You earned 2 frequent renter pointers"
        );
    }
}
