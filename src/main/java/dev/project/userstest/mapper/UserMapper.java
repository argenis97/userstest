package dev.project.userstest.mapper;

import dev.project.userstest.dto.UserDTO;
import dev.project.userstest.persistence.entity.AppUser;
import dev.project.userstest.persistence.entity.Role;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roleID", expression = "java(user.getRole().getId())")
    UserDTO toDTO(AppUser user);

    AppUser toUser(UserDTO dto);

    @AfterMapping
    default void afterMappingUser(UserDTO dto, @MappingTarget AppUser user) {
        Role role = new Role();
        role.setId(dto.getRoleID());

        user.setRole(role);
    }
}
