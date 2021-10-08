package com.interpark.SpringBootCommunityWeb.service;

import com.interpark.SpringBootCommunityWeb.domain.Board;
import com.interpark.SpringBootCommunityWeb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable
                .getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable); // 기본 페이지 크기 10, 0이하일 때 0으로 초기화
    }

    public Board findBoardByIdx(Long idx) {
        return boardRepository.findById(idx).orElse(new Board());
    }
}

