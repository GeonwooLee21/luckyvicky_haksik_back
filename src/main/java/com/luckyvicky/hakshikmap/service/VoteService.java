package com.luckyvicky.hakshikmap.service;


import com.luckyvicky.hakshikmap.dto.VoteReq;
import com.luckyvicky.hakshikmap.entity.Users;
import com.luckyvicky.hakshikmap.entity.Votes;
import com.luckyvicky.hakshikmap.repository.UsersRepository;
import com.luckyvicky.hakshikmap.repository.VotesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class VoteService {
    private final UsersRepository usersRepository;
    private final VotesRepository votesRepository;

    public void vote(VoteReq voteReq) {
        // 1) userId로 유저 조회
        Users user = usersRepository.findById(voteReq.userId())
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다. id=" + voteReq.userId()));

        // 2) 잔여 투표 수 체크
        if (user.getRemainingVoteCount() <= 0) {
            throw new IllegalStateException("오늘 사용 가능한 투표 횟수를 모두 사용했습니다.");
        }

        // 3) 혼잡도에 따라 weight 계산 (예: HIGH=3, MID=2, 나머지=1)
        int weight = switch (voteReq.congestionLevel()) {
            case "HIGH" -> 3;
            case "MID" -> 2;
            default -> 1;
        };

        // 4) Votes 엔티티 생성
        Votes vote = Votes.builder()
                .userId(voteReq.userId())
                .restaurantId(voteReq.restaurantId())
                .congestionLevel(voteReq.congestionLevel())
                .weight(weight)
                .waitingTime(voteReq.waitingTime())
                .votedTime(LocalDateTime.now())
                .build();

        // 5) 저장
        votesRepository.save(vote);

        // 6) 유저 잔여 투표 수 1 감소
        user.setRemainingVoteCount(user.getRemainingVoteCount() - 1);
    }
}
