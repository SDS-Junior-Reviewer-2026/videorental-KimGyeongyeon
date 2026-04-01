package com.videorental;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MovieRentStrategyFactory {
    // 전략 객체들을 싱글톤 인스턴스로 미리 생성하여 Map에 캐싱 (Flyweight)
    private static final Map<Integer, MovieRentStrategy> PRICE_REGISTRY;

    static {
        Map<Integer, MovieRentStrategy> map = new HashMap<>();
        map.put(Movie.REGULAR, new RegularMovieRentStrategy());
        map.put(Movie.CHILDRENS, new ChildrensMovieRentStrategy());
        map.put(Movie.NEW_RELEASE, new NewReleaseMovieRentStrategy());

        // 불변 맵으로 만들어 안전성 보장
        PRICE_REGISTRY = Collections.unmodifiableMap(map);
    }

    public static MovieRentStrategy getStrategy(int priceCode) {
        MovieRentStrategy strategy = PRICE_REGISTRY.get(priceCode);
        if (strategy == null) {
            throw new IllegalArgumentException("지원하지 않는 가격 코드입니다: " + priceCode);
        }
        return strategy;
    }
}
