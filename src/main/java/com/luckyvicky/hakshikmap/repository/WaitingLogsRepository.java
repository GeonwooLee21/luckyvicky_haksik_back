package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.WaitingLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WaitingLogsRepository extends JpaRepository<WaitingLogs, Integer> {

}
