package com.study.boardappvuespring.domain.user;

import com.study.boardappvuespring.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;

    @Override
    public void createUser(UserCommand.CreateUser command) {
        User user = command.toEntity();
        userStore.store(user);
    }
}
