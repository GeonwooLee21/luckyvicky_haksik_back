package com.luckyvicky.hakshikmap.service;

import com.luckyvicky.hakshikmap.dto.WaitTimeApiRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class WaitTimeService {

    private final RestTemplate restTemplate;

    @Value("${python.wait-time-url}")
    private String waitTimeUrl;  // application.properties에서 읽어옴

    // 파이썬에서 기대하는 포맷: "HH:mm"
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm");

    /**
     * 특정 식당에 대해, 특정 시각 기준 대기시간(분)을 파이썬 서버에서 받아온다.
     */
    public int getWaitTime(Long restaurantId, LocalDateTime time) {

        String timeString = time.format(FORMATTER);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("restaurantId", restaurantId);
        requestBody.put("timeString", timeString);

        try {
            ResponseEntity<WaitTimeApiRes> response =
                    restTemplate.postForEntity(waitTimeUrl, requestBody, WaitTimeApiRes.class);

            WaitTimeApiRes body = response.getBody();

            if (body == null) {
                log.warn("wait-time API 응답 body 가 null 입니다. restaurantId={}, time={}", restaurantId, timeString);
                return 0;
            }

            if (!"success".equalsIgnoreCase(body.getStatus())) {
                log.warn("wait-time API status 가 success 가 아닙니다. status={}, restaurantId={}, time={}",
                        body.getStatus(), restaurantId, timeString);
                return 0;
            }

            if (body.getWaitTimeMin() == null) {
                log.warn("wait-time API 에서 waitTimeMin 이 null 입니다. restaurantId={}, time={}", restaurantId, timeString);
                return 0;
            }

            return body.getWaitTimeMin();
        } catch (RestClientException e) {
            log.error("wait-time API 호출 중 에러 발생. restaurantId={}, time={}", restaurantId, timeString, e);
            // 에러 나면 일단 0분으로 반환 (정책은 나중에 조정 가능)
            return 0;
        }
    }
}
