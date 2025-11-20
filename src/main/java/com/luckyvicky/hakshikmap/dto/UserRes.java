package com.luckyvicky.hakshikmap.dto;

import com.luckyvicky.hakshikmap.entity.Users;

public record UserRes(
        Long userId,
        String userToken,
        int remainingVoteCount
) {
    public static UserRes from(Users user) {
        return new UserRes(
                user.getId(),
                user.getUserToken(),
                user.getRemainingVoteCount()
        );
    }
}
