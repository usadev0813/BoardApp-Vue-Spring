package com.study.boardappvuespring.domain.post;

import java.util.List;

public interface PostReader {
    List<Post> getPosts();
    Post getPost(Long id);
}
