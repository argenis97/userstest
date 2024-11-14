package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemResponseDTO {
    private BigDecimal qtyTrx;
    private BigDecimal priceTrx;
    private Long productId;
    private Long itemId;
}
