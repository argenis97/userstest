package dev.project.userstest.mapper;

import dev.project.userstest.dto.PurchaseItemDTO;
import dev.project.userstest.persistence.entity.Product;
import dev.project.userstest.persistence.entity.PurchaseItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mapping(source = "qty", target = "qtyTrx")
    @Mapping(source = "price", target = "priceTrx")
    @Mapping(expression = "java(item.getProduct().getId())", target = "productID")
    PurchaseItemDTO toDTO(PurchaseItem item);

    @InheritInverseConfiguration
    PurchaseItem toEntity(PurchaseItemDTO dto);

    @AfterMapping
    default void afterMapping(PurchaseItemDTO dto, @MappingTarget PurchaseItem item) {
        Product product = new Product();
        product.setId(dto.getProductID());
        item.setProduct(product);
    }
}
