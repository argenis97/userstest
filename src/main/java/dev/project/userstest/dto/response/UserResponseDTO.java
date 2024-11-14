package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDTO {
    private Long userId;
    private String userName;
    private Long roleId;
}
