package com.study.boardappvuespring.presentation.post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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
