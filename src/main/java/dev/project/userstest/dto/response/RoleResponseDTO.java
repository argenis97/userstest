package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO {
    private String roleName;
    private String descriptionText;
    private Long roleId;
    
    private List<PermissionResponseDTO> rolePermissions;
}
