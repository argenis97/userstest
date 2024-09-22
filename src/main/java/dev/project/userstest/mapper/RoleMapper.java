package dev.project.userstest.mapper;

import dev.project.userstest.dto.RoleDTO;
import dev.project.userstest.persistence.entity.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class})
public interface RoleMapper {

    @Mapping(source = "id", target = "roleID")
    public RoleDTO toDTO(Role role);

    @InheritInverseConfiguration
    public Role toRole(RoleDTO dto);

    @AfterMapping
    public default void afterMapping(RoleDTO dto, @MappingTarget Role role){
        role.getPermissions().forEach(permission -> permission.setRole(role));
    }
}
