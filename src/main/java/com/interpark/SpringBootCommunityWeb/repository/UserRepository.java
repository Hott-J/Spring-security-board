package com.interpark.SpringBootCommunityWeb.repository;

import com.interpark.SpringBootCommunityWeb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
