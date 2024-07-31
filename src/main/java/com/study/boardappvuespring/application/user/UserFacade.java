package com.study.boardappvuespring.application.user;

import com.study.boardappvuespring.domain.user.UserCommand;
import com.study.boardappvuespring.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public void createUser(UserCommand.CreateUser request) {
        userService.createUser(request);
    }
}
