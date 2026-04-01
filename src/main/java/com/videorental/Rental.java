package com.videorental;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public RentalStatement getRentalStatement() {
		return movie.getRentalStatement(daysRented);
	}
}

class RentalStatement {
	double amount;
	int frequency;
	String middleLine;

	public RentalStatement(double amount, int frequency, String middleLine) {
		this.amount = amount;
		this.frequency = frequency;
		this.middleLine = middleLine;
	}
}