package dev.project.userstest.service;

import dev.project.userstest.dto.PurchaseDTO;
import dev.project.userstest.mapper.PurchaseMapper;
import dev.project.userstest.persistence.entity.Purchase;
import dev.project.userstest.persistence.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseMapper mapper;
    private final PurchaseRepository repository;

    public PurchaseServiceImpl(PurchaseMapper mapper, PurchaseRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public PurchaseDTO save(PurchaseDTO dto) {
        Purchase purchase = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(purchase);
    }

    @Override
    public Optional<PurchaseDTO> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Override
    public List<PurchaseDTO> findAll() {
        return mapper.toListPurchase(repository.findAll());
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
}
