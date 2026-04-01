package com.videorental;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;
	private MovieRentStrategy strategy;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
		this.strategy = MovieRentStrategyFactory.getStrategy(priceCode);
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		priceCode = arg;
	}

	public String getTitle() {
		return title;
	}

	private double getAmount(int daysRented) {
		return strategy.getCharge(daysRented);
	}

	private int getFrequency(int daysRented) {
		return strategy.getFrequentPoint(daysRented);
	}

	private String getStatementString(double amount) {
		return "\t" + amount + "(" + title + ")\n";
	}

	public RentalStatement getRentalStatement(int daysRented) {
		double amt = this.getAmount(daysRented);
		return new RentalStatement(
				amt,
				this.getFrequency(daysRented),
				this.getStatementString(amt)
		);
	}
}