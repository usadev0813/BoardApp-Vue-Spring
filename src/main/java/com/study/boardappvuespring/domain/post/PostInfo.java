package com.study.boardappvuespring.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class PostInfo {
    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String title;
        private final String content;
    }
}
