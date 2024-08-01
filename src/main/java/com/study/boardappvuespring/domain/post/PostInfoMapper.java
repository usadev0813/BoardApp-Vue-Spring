package com.study.boardappvuespring.domain.post;

import com.study.boardappvuespring.domain.user.User;
import com.study.boardappvuespring.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PostInfoMapper {
    PostInfo.RegisterResponse of(Post post);
}
