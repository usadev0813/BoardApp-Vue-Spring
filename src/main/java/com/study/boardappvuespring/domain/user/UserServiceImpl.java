package com.study.boardappvuespring.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;
    private final UserInfoMapper userInfoMapper;


    @Override
    public UserInfo.RegisterResponse registerUser(UserCommand.RegisterUser command) {
        User user = command.toEntity();
        return userInfoMapper.of(userStore.store(user));
    }
}
