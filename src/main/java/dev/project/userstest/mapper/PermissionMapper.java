package dev.project.userstest.mapper;

import dev.project.userstest.dto.PermissionDTO;
import dev.project.userstest.persistence.entity.Permission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "id", target = "permissionID")
    public PermissionDTO toDTO(Permission permission);

    @InheritInverseConfiguration
    public Permission toPermission(PermissionDTO dto);
}
