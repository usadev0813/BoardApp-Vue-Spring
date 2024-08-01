package com.study.boardappvuespring.domain.post;

import com.study.boardappvuespring.domain.user.User;
import lombok.Builder;
import lombok.Data;

public class PostCommand {

    @Data
    @Builder
    public static class RegisterPost {
        private final String writerId;
        private final String title;
        private final String content;

        public Post toEntity(User user) {
            return Post.builder()
                    .user(user)
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
