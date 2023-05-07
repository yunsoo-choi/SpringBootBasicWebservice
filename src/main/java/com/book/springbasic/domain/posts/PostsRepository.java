package com.book.springbasic.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 생성 후, JPARepository를 상속하면 기본적인 CRUD 메소드 자동 생성함 
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
