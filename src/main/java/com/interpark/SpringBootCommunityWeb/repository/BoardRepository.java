package com.interpark.SpringBootCommunityWeb.repository;

import com.interpark.SpringBootCommunityWeb.domain.Board;
import com.interpark.SpringBootCommunityWeb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
