package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorResponseDTO {
    private Long vendorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String location;
}
