package com.luckyvicky.hakshikmap.repository;
import com.luckyvicky.hakshikmap.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserToken(String userToken);
}
