package dev.project.userstest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendorRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String location;
}
