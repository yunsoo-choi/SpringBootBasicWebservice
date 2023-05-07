package com.book.springbasic.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;                                 // Column, Entity, GeneratedValue, GenerationType, Id ...

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    // JPA - Table COL 구성
    @Id                                                     // PK 지정 annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)                 // Column속성의 default값 변경
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // Build 패턴 생성 (생성자 대체)
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
