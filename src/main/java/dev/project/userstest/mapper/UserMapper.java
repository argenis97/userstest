package dev.project.userstest.mapper;

import dev.project.userstest.dto.request.UpdateUserRequest;
import dev.project.userstest.dto.request.UserRequestDTO;
import dev.project.userstest.dto.response.UserResponseDTO;
import dev.project.userstest.persistence.entity.AppUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "userName")
    @Mapping(source = "role.id", target = "roleId")
    UserResponseDTO toResponse(AppUser user);

    @Mapping(source = "userName", target = "name")
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(target = "password", ignore = true)
    AppUser toEntity(UserRequestDTO request);

    @Mapping(source = "roleId", target = "role.id")
    @Mapping(target = "password", ignore = true)
    void updateValues(UpdateUserRequest dto, @MappingTarget AppUser user);

    List<UserResponseDTO> toListResponse(List<AppUser> users);
}
