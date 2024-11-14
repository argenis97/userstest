package dev.project.userstest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private String value;
    private String productName;
    private BigDecimal priceActual;
    private Long productId;
}
