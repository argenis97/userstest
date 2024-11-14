package dev.project.userstest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItemRequestDTO {
    private BigDecimal qtyTrx;
    private BigDecimal priceTrx;
    private Long productId;
}
