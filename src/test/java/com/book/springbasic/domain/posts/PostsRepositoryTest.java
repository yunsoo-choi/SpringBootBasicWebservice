package com.book.springbasic.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
// 아래는 자동생성 안된 라이브러리       -> ????
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After                                                  // Junit 단위테스트가 끝날때마다 수행되는 메소드 지정 annotation
    public void cleanup(){
        postsRepository.deleteAll();                        // 테스트용 메모리 DB 인 H2의 데이터 비워줌
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 1. save 기능 확인
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("yyss241@naver.com")                // ??? 수정
                .build());

        // when
        // 2. findAll 기능 확인
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
