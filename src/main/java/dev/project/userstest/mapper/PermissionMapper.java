package dev.project.userstest.mapper;

import dev.project.userstest.dto.request.PermissionRequestDTO;
import dev.project.userstest.dto.response.PermissionResponseDTO;
import dev.project.userstest.persistence.entity.Permission;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(source = "id", target = "permissionId")
    @Mapping(source = "name", target = "permissionName")
    PermissionResponseDTO toResponse(Permission permission);

    @Mapping(source = "permissionName", target = "name")
    Permission toEntity(PermissionRequestDTO dto);

    @Mapping(source = "permissionName", target = "name")
    void updateValues(PermissionRequestDTO dto, @MappingTarget Permission permission);

    List<PermissionResponseDTO> toListResponse(List<Permission> permissions);
}
