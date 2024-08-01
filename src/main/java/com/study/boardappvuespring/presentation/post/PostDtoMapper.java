package com.study.boardappvuespring.presentation.post;

import com.study.boardappvuespring.domain.post.PostCommand;
import com.study.boardappvuespring.domain.user.UserCommand;
import com.study.boardappvuespring.domain.user.UserInfo;
import com.study.boardappvuespring.presentation.user.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PostDtoMapper {
    PostCommand.RegisterPost of(PostDto.RegisterRequest request);
}
