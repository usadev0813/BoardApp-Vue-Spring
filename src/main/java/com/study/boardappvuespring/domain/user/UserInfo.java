package com.study.boardappvuespring.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class UserInfo {
    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String userId;
        private final String name;
    }
}
