package com.study.boardappvuespring.infrastructure.user;

import com.study.boardappvuespring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String userId);
}
