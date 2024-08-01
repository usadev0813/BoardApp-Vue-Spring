package com.study.boardappvuespring.infrastructure.post;

import com.study.boardappvuespring.domain.post.Post;
import com.study.boardappvuespring.domain.post.PostStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PostStoreImpl implements PostStore {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post store(Post registerPost) {
        return postRepository.save(registerPost);
    }
}
