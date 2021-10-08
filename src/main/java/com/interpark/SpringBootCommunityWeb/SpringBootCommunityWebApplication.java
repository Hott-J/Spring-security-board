package com.interpark.SpringBootCommunityWeb;

import com.interpark.SpringBootCommunityWeb.domain.Board;
import com.interpark.SpringBootCommunityWeb.domain.User;
import com.interpark.SpringBootCommunityWeb.domain.enums.BoardType;
import com.interpark.SpringBootCommunityWeb.repository.BoardRepository;
import com.interpark.SpringBootCommunityWeb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootCommunityWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommunityWebApplication.class, args);
	}

	// DI
	// 구동 시점에 특정 코드 실행
	@Bean
	public CommandLineRunner runner(UserRepository userRepository,
									BoardRepository boardRepository) throws Exception {
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("hakjae")
					.password("1111")
					.email("chung1306@interpark.com")
					.createdDate(LocalDateTime.now())
					.build());

			// 인덱스 순서대로 Board 객체 200개 생성하여 저장
			IntStream.rangeClosed(1, 200).forEach(index ->
					boardRepository.save(Board.builder()
					.title("게시글" + index)
					.subTitle("순서" + index)
					.content("콘텐츠")
					.boardType(BoardType.free)
					.createdDate(LocalDateTime.now())
					.updatedDate(LocalDateTime.now())
					.user(user).build()));
		};
	}
}
