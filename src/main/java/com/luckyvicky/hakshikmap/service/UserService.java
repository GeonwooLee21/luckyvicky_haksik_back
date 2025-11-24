package com.luckyvicky.hakshikmap.service;

import com.luckyvicky.hakshikmap.dto.UserRes;
import com.luckyvicky.hakshikmap.dto.UserVoteCountRes;
import com.luckyvicky.hakshikmap.entity.Users;
import com.luckyvicky.hakshikmap.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class UserService {
    private final UsersRepository usersRepository;

    public UserRes create() {
        // 1) 랜덤한 토큰 생성 (UUID 같은 걸로)
        String token = UUID.randomUUID().toString();

        // 2) Users 엔티티 생성
        Users user = Users.builder()
                .userToken(token)
                .remainingVoteCount(2)          // 초기 투표 가능 횟수
                .build();

        usersRepository.save(user);

        // 3) DTO로 변환해서 반환
        return UserRes.from(user);
    }

    public UserVoteCountRes getUserVoteCount(String token) {
        Users user = usersRepository.findByUserToken(token)
                .orElseThrow(() -> new IllegalArgumentException("해당 토큰을 가진 유저가 없습니다."));
        return UserVoteCountRes.from(user);
    }
}
