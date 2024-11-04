package dev.project.userstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendorDTO {
    private Long vendorID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String location;
}
