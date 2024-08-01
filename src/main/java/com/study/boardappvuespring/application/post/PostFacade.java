package com.study.boardappvuespring.application.post;

import com.study.boardappvuespring.domain.post.Post;
import com.study.boardappvuespring.domain.post.PostCommand;
import com.study.boardappvuespring.domain.post.PostInfo;
import com.study.boardappvuespring.domain.post.PostService;
import com.study.boardappvuespring.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;

    public PostInfo.RegisterResponse registerPost(PostCommand.RegisterPost request) {
        return postService.registerPost(request);
    }
}
