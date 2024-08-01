package com.study.boardappvuespring.domain.post;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostStore postStore;
    private final PostReader postReader;
    private final UserReader userReader;
    private final PostInfoMapper postInfoMapper;

    @Override
    public PostInfo.Main registerPost(PostCommand.RegisterPost command) {
        User writer = userReader.getUserById(command.getWriterId());
        Post post = command.toEntity(writer);
        return postInfoMapper.of(postStore.store(post));
    }

    @Override
    public List<PostInfo.Main> getPosts() {
        return postInfoMapper.of(postReader.getPosts());
    }

    @Override
    public PostInfo.Main getPost(Long postId) {
        return postInfoMapper.of(postReader.getPost(postId));
    }
}
