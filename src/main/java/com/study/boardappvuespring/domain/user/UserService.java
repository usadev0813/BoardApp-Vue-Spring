package com.study.boardappvuespring.domain.user;

public interface UserService {
    UserInfo.RegisterResponse registerUser(UserCommand.RegisterUser user);
}
