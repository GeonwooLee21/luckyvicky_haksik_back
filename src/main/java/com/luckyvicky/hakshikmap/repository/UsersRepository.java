package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<users, Integer> {
}
