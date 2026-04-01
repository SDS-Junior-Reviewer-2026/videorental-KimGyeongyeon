package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatementTest {
    private Customer createCustomer(String name) {
        return new Customer(name);
    }

    private Rental regularRent(String title, int day) {
        return new Rental(new Movie(title, Movie.REGULAR), day);
    }

    @Test
    void given_NoMovie_then_printZeroStatement() {
        Customer customer = createCustomer("ANY_NAME");

        // when
        String stmtResult = customer.statement();

        // then
        assertThat(stmtResult).isEqualTo("Rental Record for ANY_NAME\n"
                +"Amount owed is 0.0\n"
        +"You earned 0 frequent renter pointers"
        );
    }

    @Test
    void given_RegularMovieFor2day_then_printStatement() {
        Customer customer = createCustomer("ANY_NAME");

        // when
        customer.addRental(regularRent("Regular Movie", 2));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for ANY_NAME\n" +
                        "\t2.0(Regular Movie)\n" +
                        "Amount owed is 2.0\n" +
                        "You earned 1 frequent renter pointers"
        );
    }

    @Test
    void given_RegularMovieFor3day_then_printStatement() {
        Customer customer = createCustomer("ANY_NAME");

        // when
        customer.addRental(regularRent("Regular Movie", 3));

        // then
        String stmtResult = customer.statement();
        assertThat(stmtResult).isEqualTo(
                "Rental Record for ANY_NAME\n" +
                        "\t3.5(Regular Movie)\n" +
                        "Amount owed is 3.5\n" +
                        "You earned 1 frequent renter pointers"
        );
    }
}
