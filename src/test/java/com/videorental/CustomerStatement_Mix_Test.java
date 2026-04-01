package com.videorental;

import org.junit.jupiter.api.Test;

import static com.videorental.TestFixture.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatement_Mix_Test {
    @Test
    void given_3RegularMovieFor2day_then_printStatement() {
        Customer customer = createCustomer("ANY_NAME");

        // when
        customer.addRental(regularRent("Regular Movie1", 2));
        customer.addRental(regularRent("Regular Movie2", 2));
        customer.addRental(regularRent("Regular Movie3", 2));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for ANY_NAME\n" +
                        "\t2.0(Regular Movie1)\n" +
                        "\t2.0(Regular Movie2)\n" +
                        "\t2.0(Regular Movie3)\n" +
                        "Amount owed is 6.0\n" +
                        "You earned 3 frequent renter pointers"
        );
    }

    @Test
    public void given_3NewReleaseMovieFor7day_then_63원청구() {
        // given
        Customer c = createCustomer("James");

        // when
        c.addRental(newRent("New Movie1", 7));
        c.addRental(newRent("New Movie2", 7));
        c.addRental(newRent("New Movie3", 7));
        String stmt = c.statement();

        // then
        assertThat(stmt).isEqualTo(
                "Rental Record for James\n" +
                        "\t21.0(New Movie1)\n" +
                        "\t21.0(New Movie2)\n" +
                        "\t21.0(New Movie3)\n" +
                        "Amount owed is 63.0\n" +
                        "You earned 6 frequent renter pointers"
        );
    }

    @Test
    void given_4ChildrenMovieFor4day_then_printStatement() {
        Customer customer = createCustomer("John");

        // when
        customer.addRental(childrenRent("Child Movie1", 4));
        customer.addRental(childrenRent("Child Movie2", 4));
        customer.addRental(childrenRent("Child Movie3", 4));
        customer.addRental(childrenRent("Child Movie4", 4));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John\n" +
                        "\t3.0(Child Movie1)\n" +
                        "\t3.0(Child Movie2)\n" +
                        "\t3.0(Child Movie3)\n" +
                        "\t3.0(Child Movie4)\n" +
                        "Amount owed is 12.0\n" +
                        "You earned 4 frequent renter pointers"
        );
    }

    @Test
    void given_Regular3D_Children2D_New4D_then_printStatement() {
        Customer customer = createCustomer("John");

        // when
        customer.addRental(regularRent("Movie1", 3));
        customer.addRental(childrenRent("Movie2", 2));
        customer.addRental(newRent("Movie3", 4));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John\n" +
                        "\t3.5(Movie1)\n" +
                        "\t1.5(Movie2)\n" +
                        "\t12.0(Movie3)\n" +
                        "Amount owed is 17.0\n" +
                        "You earned 4 frequent renter pointers"
        );
    }
}
