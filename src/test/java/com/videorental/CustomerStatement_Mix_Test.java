package com.videorental;

import org.junit.jupiter.api.Test;

import static com.videorental.TestFixture.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatement_Mix_Test {
    private final String CUSTOMER_NAME = "John Doe";
    private final String MOVIE_PREFIX = "Movie";
    @Test
    void given_3RegularMovieFor2day_then_printStatement() {
        Customer customer = createCustomer(CUSTOMER_NAME);

        // when
        customer.addRental(regularRent(MOVIE_PREFIX+"1", 2));
        customer.addRental(regularRent(MOVIE_PREFIX+"2", 2));
        customer.addRental(regularRent(MOVIE_PREFIX+"3", 2));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John Doe\n" +
                        "\t2.0(Movie1)\n" +
                        "\t2.0(Movie2)\n" +
                        "\t2.0(Movie3)\n" +
                        "Amount owed is 6.0\n" +
                        "You earned 3 frequent renter pointers"
        );
    }

    @Test
    public void given_3NewReleaseMovieFor7day_then_63원청구() {
        // given
        Customer c = createCustomer(CUSTOMER_NAME);

        // when
        c.addRental(newRent(MOVIE_PREFIX+"1", 7));
        c.addRental(newRent(MOVIE_PREFIX+"2", 7));
        c.addRental(newRent(MOVIE_PREFIX+"3", 7));
        String stmt = c.statement();

        // then
        assertThat(stmt).isEqualTo(
                "Rental Record for John Doe\n" +
                        "\t21.0(Movie1)\n" +
                        "\t21.0(Movie2)\n" +
                        "\t21.0(Movie3)\n" +
                        "Amount owed is 63.0\n" +
                        "You earned 6 frequent renter pointers"
        );
    }

    @Test
    void given_4ChildrenMovieFor4day_then_printStatement() {
        Customer customer = createCustomer(CUSTOMER_NAME);

        // when
        customer.addRental(childrenRent(MOVIE_PREFIX+"1", 4));
        customer.addRental(childrenRent(MOVIE_PREFIX+"2", 4));
        customer.addRental(childrenRent(MOVIE_PREFIX+"3", 4));
        customer.addRental(childrenRent(MOVIE_PREFIX+"4", 4));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John Doe\n" +
                        "\t3.0(Movie1)\n" +
                        "\t3.0(Movie2)\n" +
                        "\t3.0(Movie3)\n" +
                        "\t3.0(Movie4)\n" +
                        "Amount owed is 12.0\n" +
                        "You earned 4 frequent renter pointers"
        );
    }

    @Test
    void given_Regular3D_Children2D_New4D_then_printStatement() {
        Customer customer = createCustomer(CUSTOMER_NAME);

        // when
        customer.addRental(regularRent(MOVIE_PREFIX+"1", 3));
        customer.addRental(childrenRent(MOVIE_PREFIX+"2", 2));
        customer.addRental(newRent(MOVIE_PREFIX+"3", 4));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John Doe\n" +
                        "\t3.5(Movie1)\n" +
                        "\t1.5(Movie2)\n" +
                        "\t12.0(Movie3)\n" +
                        "Amount owed is 17.0\n" +
                        "You earned 4 frequent renter pointers"
        );
    }
}
