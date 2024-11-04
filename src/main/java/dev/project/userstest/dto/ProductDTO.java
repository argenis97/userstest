package dev.project.userstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Long productID;
    private String value;
    private String productName;
    private BigDecimal priceActual;
}
