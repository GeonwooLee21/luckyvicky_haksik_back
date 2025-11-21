package com.luckyvicky.hakshikmap.service;

import com.luckyvicky.hakshikmap.dto.RestaurantCongestionRes;
import com.luckyvicky.hakshikmap.entity.Restaurants;
import com.luckyvicky.hakshikmap.repository.RestaurantsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantService {

    private final RestaurantsRepository restaurantsRepository;

    public List<RestaurantCongestionRes> getAllCongestions() {
        List<Restaurants> restaurants = restaurantsRepository.findAll();
        return restaurants.stream()
                .map(RestaurantCongestionRes::from)
                .toList();
    }

    public RestaurantCongestionRes getCongestion(Long restaurantId) {
        Restaurants restaurant = restaurantsRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 식당을 찾을 수 없습니다. id=" + restaurantId));

        return RestaurantCongestionRes.from(restaurant);
    }
}