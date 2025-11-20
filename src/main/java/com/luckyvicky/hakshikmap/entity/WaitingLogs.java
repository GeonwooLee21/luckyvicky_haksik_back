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
@Table(name = "waitingLogs")
public class WaitingLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;                          // 로그 ID

    @JoinColumn(name = "restaurantId", nullable = false)
    private Long restaurant;           // 어떤 식당의 로그인지

    @Column(name = "loggedTime", nullable = false)
    private LocalDateTime loggedTime;        // 이 데이터가 의미하는 시각

    @Column(name = "waitedMinutes", nullable = false)
    private int waitedMinutes;               // 그 시간대의 대기 시간(분)
}
