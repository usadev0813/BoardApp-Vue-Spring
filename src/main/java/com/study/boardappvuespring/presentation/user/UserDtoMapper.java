package com.study.boardappvuespring.presentation.user;

import com.study.boardappvuespring.domain.user.UserCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {
    UserCommand.CreateUser of(UserDto.CreateUser request);
}
