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
@Table(name = "votes")
public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;                           // 각 투표 ID

    // 학식당 FK
    @JoinColumn(name = "restaurantId", nullable = false)
    private Long restaurantId;            // 어떤 식당에 대한 투표인지

    // 유저 FK
    @JoinColumn(name = "userId", nullable = false)
    private Long userId;                        // 어떤 유저(세션)가 한 투표인지

    @Column(name = "congestionLevel", nullable = false, length = 10)
    private String congestionLevel;           // 혼잡도: "HIGH" / "MID" / "LOW"

    @Column(name = "weight", nullable = false)
    private int weight;                       // 가중치: 혼잡3, 보통2, 여유1

    @Column(name = "waitingTime", nullable = false)
    private int waitingTime;                  // 사용자가 선택한 대기 시간(분)

    @Column(name = "votedTime", nullable = false)
    private LocalDateTime votedTime;          // 투표 시각
}
