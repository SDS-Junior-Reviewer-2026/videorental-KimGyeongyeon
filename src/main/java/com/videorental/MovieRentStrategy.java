package com.videorental;

// 가격 정책의 추상화
public abstract class MovieRentStrategy {
    public abstract int getPriceCode();

    // 향후 요금 계산 로직(getCharge), 적립 포인트 계산 로직 등이 이 클래스로 이동하게 됩니다.
     public abstract double getCharge(int daysRented);
     public abstract int getFrequentPoint(int daysRented);
}

class ChildrensMovieRentStrategy extends MovieRentStrategy {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentPoint(int daysRented) {
        return 1;
    }
}

class RegularMovieRentStrategy extends MovieRentStrategy {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentPoint(int daysRented) {
        return 1;
    }
}

class NewReleaseMovieRentStrategy extends MovieRentStrategy {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentPoint(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}