package com.study.boardappvuespring.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class PostInfo {
    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String id;
        private final String title;
        private final String content;
        private final String writer;
        private final String createAt;
    }

}
