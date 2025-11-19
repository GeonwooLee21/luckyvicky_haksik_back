package com.luckyvicky.hakshikmap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;                         // 유저 ID(익명 세션)

    @Column(name = "userToken", nullable = false, unique = true, length = 64)
    private String userToken;               // 브라우저에 저장되는 토큰

    @Column(name = "remainingVoteCount", nullable = false)
    private int remainingVoteCount;         // 잔여 투표 횟수 (기본 2)

    @Column(name = "createdTime", nullable = false)
    private LocalDateTime createdTime;      // 세션 생성 시각
}
