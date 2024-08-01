package com.study.boardappvuespring.application.post;

import com.study.boardappvuespring.common.support.response.ApiResponse;
import com.study.boardappvuespring.domain.post.PostCommand;
import com.study.boardappvuespring.domain.post.PostInfo;
import com.study.boardappvuespring.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;

    public PostInfo.Main registerPost(PostCommand.RegisterPost request) {
        return postService.registerPost(request);
    }
    public List<PostInfo.Main> getPosts() {
        return postService.getPosts();
    }

    public PostInfo.Main getPost(Long postId) {
        return postService.getPost(postId);
    }
}
