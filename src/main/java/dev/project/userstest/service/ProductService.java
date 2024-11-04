package dev.project.userstest.service;

import dev.project.userstest.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO save(ProductDTO dto);
    Optional<ProductDTO> findById(Long id);
    boolean delete(Long id);
    List<ProductDTO> findAll();
}
