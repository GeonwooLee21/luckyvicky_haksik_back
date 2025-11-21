package com.luckyvicky.hakshikmap.dto;

public record VoteReq(
        Long userId,
        Long restaurantId,
        String congestionLevel,  // "HIGH", "MID", "LOW"
        int waitingTime          // 사용자가 선택한 대기 시간(분)
) {
}
