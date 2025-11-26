package com.luckyvicky.hakshikmap.dto;

public record RestaurantWaitTimeRes(
        Long restaurantId,
        int waitTimeMin
) {
}
