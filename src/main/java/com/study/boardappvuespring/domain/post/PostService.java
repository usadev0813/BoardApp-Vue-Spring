package com.study.boardappvuespring.domain.post;

import com.study.boardappvuespring.domain.user.UserInfo;

public interface PostService {
    PostInfo.RegisterResponse registerPost(PostCommand.RegisterPost post);
}
