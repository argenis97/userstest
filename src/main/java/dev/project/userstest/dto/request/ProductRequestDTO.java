package dev.project.userstest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDTO {
    private String value;
    private String productName;
    private BigDecimal priceActual;
}
