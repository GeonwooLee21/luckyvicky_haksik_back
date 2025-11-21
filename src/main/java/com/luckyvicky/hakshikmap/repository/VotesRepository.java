package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VotesRepository extends JpaRepository<Votes, Long> {
    List<Votes> findByRestaurantIdAndVotedTimeBetween(
            Long restaurantId,
            LocalDateTime from,
            LocalDateTime to
    );
}
