package com.luckyvicky.hakshikmap.dto;

import com.luckyvicky.hakshikmap.entity.Users;

public record UserVoteCountRes(
        Long userId,
        int remainingVoteCount
) {
    public static UserVoteCountRes from(Users user) {
        return new UserVoteCountRes(
                user.getId(),
                user.getRemainingVoteCount()
        );
    }
}
