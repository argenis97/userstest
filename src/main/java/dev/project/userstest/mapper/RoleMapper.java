package dev.project.userstest.mapper;

import dev.project.userstest.dto.RoleDTO;
import dev.project.userstest.persistence.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface RoleMapper {

    @Mapping(source = "id", target = "roleID")
    RoleDTO toDTO(Role role);

    @InheritInverseConfiguration
    Role toRole(RoleDTO dto);

    @AfterMapping
    default void afterMapping(RoleDTO dto, @MappingTarget Role role){
        role.getPermissions().forEach(permission -> permission.setRole(role));
    }
}
