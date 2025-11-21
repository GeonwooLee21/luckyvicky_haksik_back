package com.luckyvicky.hakshikmap.controller;

import com.luckyvicky.hakshikmap.dto.VoteReq;
import com.luckyvicky.hakshikmap.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vote")
public class VotesController {

    private final VoteService votesService;

    @PostMapping
    public void vote(@RequestBody VoteReq voteReq) {
        // 이 창에 들어왔다는 것은 이미 유저가 존재한다고 가정
        votesService.vote(voteReq);
        // 반환값 없이 200 OK만 리턴
    }
}
