package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.waitingLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WaitingLogsRepository extends JpaRepository<waitingLogs, Integer> {

}
