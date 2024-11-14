package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDTO {
    private Long vendorID;
    private LocalDateTime dateTrx;
    private String purchaseStatus;
    private Long purchaseID;

    private List<PurchaseItemResponseDTO> purchaseItems;
}
