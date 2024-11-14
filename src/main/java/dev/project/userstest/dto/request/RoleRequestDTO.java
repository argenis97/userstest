package dev.project.userstest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDTO {
    private String roleName;
    private String descriptionText;

    private List<PermissionRequestDTO> rolePermissions;
}
