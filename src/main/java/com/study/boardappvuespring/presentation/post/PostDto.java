package com.study.boardappvuespring.presentation.post;

import com.study.boardappvuespring.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class PostDto {
    @Getter
    @Builder
    @ToString
    public static class RegisterRequest {
        private final String writerId;
        private final String title;
        private final String content;
    }

}
