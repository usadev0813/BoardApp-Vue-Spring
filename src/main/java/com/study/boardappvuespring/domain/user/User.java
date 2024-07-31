package com.study.boardappvuespring.domain.user;

import ch.qos.logback.core.util.StringUtil;
import com.study.boardappvuespring.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "tb_user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column(unique = true)
    private String id;

    @Column
    private String password;

    @Column(unique = true)
    private String name;

    @Builder
    public User(
            String id,
            String password,
            String name) {
        if (StringUtil.isNullOrEmpty(id)) throw new InvalidParameterException("User.id");
        if (StringUtil.isNullOrEmpty(password)) throw new InvalidParameterException("User.password");
        if (StringUtil.isNullOrEmpty(name)) throw new InvalidParameterException("User.name");

        this.id = id;
        this.password = password;
        this.name = name;
    }

}
