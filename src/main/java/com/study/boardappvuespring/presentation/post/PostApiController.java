package com.study.boardappvuespring.presentation.post;

import com.study.boardappvuespring.application.post.PostFacade;
import com.study.boardappvuespring.application.user.UserFacade;
import com.study.boardappvuespring.common.support.response.ApiResponse;
import com.study.boardappvuespring.presentation.user.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostApiController {
    private final PostFacade postFacade;
    private final PostDtoMapper postDtoMapper;

    @PostMapping("/register")
    public ApiResponse registerPost(@RequestBody PostDto.RegisterRequest request) {
        var command = postDtoMapper.of(request);
        return ApiResponse.success(postFacade.registerPost(command));
    }

    @GetMapping
    public ApiResponse getPosts(@RequestBody PostDto.RegisterRequest request) {
        // todo 포스트 전체 조회 기능 구현예정
        return null;
    }

    @PostMapping("/{postId}")
    public ApiResponse getPost(@PathVariable("postId") Long postId) {
        // todo 포스트 단건 조회 기능 구현예정
        return null;
    }
}
