package dev.project.userstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItemDTO {
    private BigDecimal qtyTrx;
    private BigDecimal priceTrx;
    private Long productID;
}
