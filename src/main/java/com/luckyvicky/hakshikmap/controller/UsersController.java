package com.luckyvicky.hakshikmap.controller;

import com.luckyvicky.hakshikmap.dto.UserRes;
import com.luckyvicky.hakshikmap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor // 생성자 자동으로 만들어 줌
@RequestMapping("/api/user")
public class UsersController {
    private final UserService userService;

    @PostMapping
    public UserRes create() {
        return userService.create();
    }
}
