package com.study.boardappvuespring.presentation.user;

import lombok.*;

public class UserDto {

    @Data
    public static class RegisterRequest {
        private final String userId;
        private final String password;
        private final String name;
    }

    @Data
    public static class RegisterResponse {
        private final String userId;
        private final String name;
    }
}
