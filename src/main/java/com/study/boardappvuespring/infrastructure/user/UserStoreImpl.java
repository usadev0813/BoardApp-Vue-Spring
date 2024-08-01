package com.study.boardappvuespring.infrastructure.user;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User store(User registerUser) {
        return userRepository.save(registerUser);
    }
}
