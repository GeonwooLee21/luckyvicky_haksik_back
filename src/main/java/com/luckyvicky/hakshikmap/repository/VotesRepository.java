package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VotesRepository extends JpaRepository<Votes, Integer> {
}
