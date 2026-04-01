package com.videorental;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    @Test
    public void testCustomerCreation() {
        Customer c = new Customer("ANY_NAME");
        assertThat(c).isNotNull();
        assert c.getName().equals("ANY_NAME");
    }
}
