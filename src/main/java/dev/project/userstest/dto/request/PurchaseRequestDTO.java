package dev.project.userstest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseRequestDTO {
    private Long vendorId;
    private LocalDateTime dateTrx;
    private String purchaseStatus;

    private List<PurchaseItemRequestDTO> purchaseItems;
}
