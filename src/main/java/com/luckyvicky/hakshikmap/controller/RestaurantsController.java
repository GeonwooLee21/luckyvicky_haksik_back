package com.luckyvicky.hakshikmap.controller;

import com.luckyvicky.hakshikmap.dto.RestaurantCongestionRes;
import com.luckyvicky.hakshikmap.repository.RestaurantsRepository;
import com.luckyvicky.hakshikmap.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor // 생성자 자동으로 만들어 줌
@RequestMapping("/api/restaurant")
public class RestaurantsController {
    private final RestaurantsRepository restaurantsRepository;
    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantCongestionRes> getAllCongestions() {
        return restaurantService.getAllCongestions();
    }

    @GetMapping("/{restaurant-id}")
    public RestaurantCongestionRes getCongestion(
            @PathVariable Long restaurantid
    ) {
       return restaurantService.getCongestion(restaurantid);
    }
}
