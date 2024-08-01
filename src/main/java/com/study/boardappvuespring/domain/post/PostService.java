package com.study.boardappvuespring.domain.post;

import java.util.List;

public interface PostService {
    PostInfo.Main registerPost(PostCommand.RegisterPost post);

    List<PostInfo.Main> getPosts();

    PostInfo.Main getPost(Long postId);
}
