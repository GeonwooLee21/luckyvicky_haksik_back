package com.luckyvicky.hakshikmap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "restaurants")
public class restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private Long id;              // 학식당 ID

    @Column(name = "name", nullable = false, length = 100)
    private String name;          // 학식당 이름 (공식당, 감꽃식당 등)

    @Column(name = "lunchOpen", nullable = false)
    private LocalTime lunchOpen;  // 점심 시작 시간

    @Column(name = "lunchClose", nullable = false)
    private LocalTime lunchClose; // 점심 종료 시간

    @Column(name = "dinnerOpen")
    private LocalTime dinnerOpen; // 저녁 시작 시간 (공식당만 존재 가능)

    @Column(name = "dinnerClose")
    private LocalTime dinnerClose; // 저녁 종료 시간
}