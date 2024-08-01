package com.study.boardappvuespring.infrastructure.post;

import com.study.boardappvuespring.common.exception.EntityNotFoundException;
import com.study.boardappvuespring.domain.post.Post;
import com.study.boardappvuespring.domain.post.PostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostReaderImpl implements PostReader {
    private final PostRepository postRepository;
    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("없습니다.")
        );
    }
}
