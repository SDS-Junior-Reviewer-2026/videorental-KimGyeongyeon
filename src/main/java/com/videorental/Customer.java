package com.videorental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> iterator = rentals.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

		while ( iterator.hasNext() ) {
			RentalStatement rs = iterator.next().getRentalStatement();
			
			// 공유변수 갱신
			totalAmount += rs.amount;
			frequentRenterPoints += rs.frequency;
			result.append(rs.middleLine);
		}

		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter pointers");

		return result.toString();
	}
}