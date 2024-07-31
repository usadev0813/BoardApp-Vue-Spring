package com.study.boardappvuespring.presentation.user;

import com.study.boardappvuespring.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserDto {
    @Getter
    @Builder
    @ToString
    public static class CreateUser {
        private final String userId;
        private final String password;
        private final String name;
    }
}
