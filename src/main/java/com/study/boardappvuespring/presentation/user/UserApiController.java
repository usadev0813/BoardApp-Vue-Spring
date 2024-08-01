package com.study.boardappvuespring.presentation.user;

import com.study.boardappvuespring.application.user.UserFacade;
import com.study.boardappvuespring.common.support.response.ApiResponse;
import com.study.boardappvuespring.domain.user.UserInfo;
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

    @PostMapping("/register")
    public ApiResponse createUser(@RequestBody UserDto.RegisterRequest request) {
        var command = userDtoMapper.of(request);
        var userInfo = userFacade.registerUser(command);
        var response = userDtoMapper.of(userInfo);
        return ApiResponse.success(response);
    }
}
