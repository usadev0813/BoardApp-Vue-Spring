package com.study.boardappvuespring.infrastructure.user;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;

    @Override
    public void store(User createUser) {
        userRepository.save(createUser);
    }
}
