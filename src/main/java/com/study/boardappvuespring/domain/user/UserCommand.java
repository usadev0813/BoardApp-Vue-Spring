package com.study.boardappvuespring.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserCommand {
    @Getter
    @Builder
    @ToString
    public static class CreateUser {
        private final String userId;
        private final String password;
        private final String name;

        public User toEntity() {
            return User.builder()
                    .id(userId)
                    .password(password)
                    .name(name)
                    .build();
        }
    }
}
