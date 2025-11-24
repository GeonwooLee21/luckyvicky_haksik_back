package com.luckyvicky.hakshikmap.dto;

import com.luckyvicky.hakshikmap.entity.Restaurants;

public record RestaurantCongestionRes(
        Long id,
        String name,
        int currentCongestion
) {
    static public RestaurantCongestionRes from(Restaurants restaurants) {
        return new RestaurantCongestionRes(
                restaurants.getId(),
                restaurants.getName(),
                restaurants.getCurrentCongestion());
    }
}
