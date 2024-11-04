package dev.project.userstest.mapper;

import dev.project.userstest.dto.ProductDTO;
import dev.project.userstest.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "productID")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "code", target = "value")
    @Mapping(source = "price", target = "priceActual")
    ProductDTO toDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(ProductDTO dto);
}
