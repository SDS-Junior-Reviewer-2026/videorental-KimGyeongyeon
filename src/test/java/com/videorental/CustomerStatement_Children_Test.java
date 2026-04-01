package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatement_Children_Test {
    private final String CUSTOMER_NAME = "John";
    private final String MOVIE_NAME = "Child Movie";

    @Test
    void given_ChildrenMovieFor3day_then_printStatement() {
        Customer customer = TestFixture.createCustomer(CUSTOMER_NAME);

        // when
        customer.addRental(TestFixture.childrenRent(MOVIE_NAME, 3));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John\n" +
                        "\t1.5(Child Movie)\n" +
                        "Amount owed is 1.5\n" +
                        "You earned 1 frequent renter pointers"
        );
    }

    @Test
    void given_ChildrenMovieFor4day_then_printStatement() {
        Customer customer = TestFixture.createCustomer(CUSTOMER_NAME);

        // when
        customer.addRental(TestFixture.childrenRent(MOVIE_NAME, 4));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for John\n" +
                        "\t3.0(Child Movie)\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter pointers"
        );
    }
}
