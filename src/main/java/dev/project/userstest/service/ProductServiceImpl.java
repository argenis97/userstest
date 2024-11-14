package dev.project.userstest.service;

import dev.project.userstest.dto.request.ProductRequestDTO;
import dev.project.userstest.dto.response.ProductResponseDTO;
import dev.project.userstest.mapper.ProductMapper;
import dev.project.userstest.persistence.entity.Product;
import dev.project.userstest.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    public ProductServiceImpl(ProductMapper mapper, ProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public ProductResponseDTO save(ProductRequestDTO dto) {
        Product product = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(product));
    }

    @Override
    public Optional<ProductResponseDTO> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return repository.findById(id)
                .stream()
                .peek(repository::delete)
                .findFirst()
                .isPresent();
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return mapper.toListResponse(repository.findAll());
    }
}
