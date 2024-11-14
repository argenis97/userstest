package dev.project.userstest.mapper;

import dev.project.userstest.dto.request.ProductRequestDTO;
import dev.project.userstest.dto.response.ProductResponseDTO;
import dev.project.userstest.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "code", target = "value")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "priceActual")
    ProductResponseDTO toResponse(Product product);

    @Mapping(source = "value", target = "code")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "priceActual", target = "price")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(source = "value", target = "code")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "priceActual", target = "price")
    void updateValues(ProductRequestDTO dto, @MappingTarget Product product);

    List<ProductResponseDTO> toListResponse(List<Product> products);
}
