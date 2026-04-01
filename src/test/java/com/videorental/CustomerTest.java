package com.videorental;

import org.junit.jupiter.api.Test;

import static com.videorental.TestFixture.createCustomer;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    private final String CUSTOMER_NAME = "ANY_NAME";
    @Test
    public void testCustomerCreation() {
        Customer c = createCustomer(CUSTOMER_NAME);
        assertThat(c).isNotNull();
        assert c.getName().equals(CUSTOMER_NAME);
    }
}
