package com.study.boardappvuespring.domain.post;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserReader;
import com.study.boardappvuespring.domain.user.UserStore;
import com.study.boardappvuespring.infrastructure.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostStore postStore;
    private final UserReader userReader;
    private final PostInfoMapper postInfoMapper;

    @Override
    public PostInfo.RegisterResponse registerPost(PostCommand.RegisterPost command) {
        User writer = userReader.getUserById(command.getWriterId());
        Post post = command.toEntity(writer);
        return postInfoMapper.of(postStore.store(post));
    }
}
