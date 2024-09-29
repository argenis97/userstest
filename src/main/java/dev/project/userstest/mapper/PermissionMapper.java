package dev.project.userstest.mapper;

import dev.project.userstest.dto.PermissionDTO;
import dev.project.userstest.persistence.entity.Permission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "id", target = "permissionID")
    PermissionDTO toDTO(Permission permission);

    List<PermissionDTO> toDTOList(List<Permission> permissions);

    @InheritInverseConfiguration
    Permission toPermission(PermissionDTO dto);
}
