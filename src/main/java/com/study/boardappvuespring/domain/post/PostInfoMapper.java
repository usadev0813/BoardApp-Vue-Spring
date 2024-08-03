package com.study.boardappvuespring.domain.post;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PostInfoMapper {
    @Mapping(source = "index", target = "id")
    @Mapping(source = "user.name", target = "writer")
    @Mapping(source = "createdAt", target = "createAt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    PostInfo.Main of(Post post);
    List<PostInfo.Main> of(List<Post> post);
}
