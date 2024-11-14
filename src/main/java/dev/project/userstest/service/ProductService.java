package dev.project.userstest.service;

import dev.project.userstest.dto.request.ProductRequestDTO;
import dev.project.userstest.dto.response.ProductResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO dto);
    Optional<ProductResponseDTO> findById(Long id);
    boolean delete(Long id);
    List<ProductResponseDTO> findAll();
}
