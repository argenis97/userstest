package dev.project.userstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseDTO {

    private Long purchaseID;
    private Long vendorID;
    private LocalDateTime dateTrx;
    private String status;

    private List<PurchaseItemDTO> items;
}
