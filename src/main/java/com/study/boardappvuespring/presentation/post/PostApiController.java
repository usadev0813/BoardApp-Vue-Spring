package com.study.boardappvuespring.presentation.post;

import com.study.boardappvuespring.application.post.PostFacade;
import com.study.boardappvuespring.application.user.UserFacade;
import com.study.boardappvuespring.common.support.response.ApiResponse;
import com.study.boardappvuespring.presentation.user.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostApiController {
    private final PostFacade postFacade;
    private final PostDtoMapper postDtoMapper;

    @PostMapping("/register")
    public ApiResponse registerPost(@RequestBody PostDto.RegisterRequest request) {
        var command = postDtoMapper.of(request);
        return ApiResponse.success(postFacade.registerPost(command));
    }

    @GetMapping
    public ApiResponse getPosts() {
        return ApiResponse.success(postFacade.getPosts());
    }

    @GetMapping("/{postId}")
    public ApiResponse getPost(@PathVariable("postId") Long postId) {
        return ApiResponse.success(postFacade.getPost(postId));
    }
}
