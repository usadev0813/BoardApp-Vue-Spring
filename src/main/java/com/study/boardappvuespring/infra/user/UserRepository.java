package com.study.boardappvuespring.infra.user;

import com.study.boardappvuespring.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
