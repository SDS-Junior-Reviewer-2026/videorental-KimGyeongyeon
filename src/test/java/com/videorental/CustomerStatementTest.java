package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerStatementTest {
    @Test
    void given_NoMovie_then_printZeroStatement() {
        Customer customer = new Customer("ANY_NAME");

        // when
        String stmtResult = customer.statement();

        // then
        assertThat(stmtResult).isEqualTo("Rental Record for ANY_NAME\n"
                +"Amount owed is 0.0\n"
        +"You earned 0 frequent renter pointers"

        );
    }
}
