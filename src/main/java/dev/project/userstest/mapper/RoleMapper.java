package dev.project.userstest.mapper;

import dev.project.userstest.dto.request.RoleRequestDTO;
import dev.project.userstest.dto.response.RoleResponseDTO;
import dev.project.userstest.persistence.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface RoleMapper {

    @Mapping(source = "id", target = "roleId")
    @Mapping(source = "name", target = "roleName")
    @Mapping(source = "description", target = "descriptionText")
    @Mapping(source = "permissions", target = "rolePermissions")
    RoleResponseDTO toResponse(Role role);

    @Mapping(source = "roleName", target = "name")
    Role toEntity(RoleRequestDTO dto);
}
