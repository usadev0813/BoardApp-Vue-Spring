package com.study.boardappvuespring.domain.post;

import ch.qos.logback.core.util.StringUtil;
import com.study.boardappvuespring.domain.BaseEntity;
import com.study.boardappvuespring.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tb_post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @Builder
    public Post(
            String title,
            String content,
            User user) {
        if (StringUtil.isNullOrEmpty(title)) throw new InvalidParameterException("Post.title");
        if (StringUtil.isNullOrEmpty(content)) throw new InvalidParameterException("Post.content");
        if (user == null) throw new InvalidParameterException("Post.user");

        this.title = title;
        this.content = content;
        this.user = user;
    }
}
