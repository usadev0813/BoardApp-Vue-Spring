package com.study.boardappvuespring.infrastructure.user;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;
    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId);
    }
}
