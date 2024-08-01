package com.study.boardappvuespring.domain.post;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PostInfoMapper {
    PostInfo.Main of(Post post);
    List<PostInfo.Main> of(List<Post> post);
}
