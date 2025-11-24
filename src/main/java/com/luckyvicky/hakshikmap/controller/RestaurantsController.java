package com.luckyvicky.hakshikmap.controller;

import com.luckyvicky.hakshikmap.dto.RestaurantCongestionRes;
import com.luckyvicky.hakshikmap.repository.RestaurantsRepository;
import com.luckyvicky.hakshikmap.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // 생성자 자동으로 만들어 줌
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/restaurant")
public class RestaurantsController {
    private final RestaurantsRepository restaurantsRepository;
    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantCongestionRes> getAllCongestions() {
        return restaurantService.getAllCongestions();
    }

    @GetMapping("/{restaurantid}")
    public RestaurantCongestionRes getCongestion(
            @PathVariable Long restaurantid
    ) {
       return restaurantService.getCongestion(restaurantid);
    }
}
