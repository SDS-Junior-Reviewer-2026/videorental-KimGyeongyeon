package com.videorental;

public class TestFixture {
    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Rental regularRent(String title, int day) {
        return new Rental(new Movie(title, Movie.REGULAR), day);
    }

    public static Rental newRent(String title, int day) {
        return new Rental(new Movie(title, Movie.NEW_RELEASE), day);
    }

    public static Rental childrenRent(String title, int day) {
        return new Rental(new Movie(title, Movie.CHILDRENS), day);
    }

}
