package com.study.boardappvuespring.presentation.user;

import com.study.boardappvuespring.application.user.UserFacade;
import com.study.boardappvuespring.common.support.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {
    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;

    @PostMapping("/create")
    public ApiResponse createUser(@RequestBody UserDto.CreateUser request) {
        var userCommand = userDtoMapper.of(request);
        userFacade.createUser(userCommand);
        return ApiResponse.success();
    }
}
