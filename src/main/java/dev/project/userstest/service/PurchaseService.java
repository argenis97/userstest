package dev.project.userstest.service;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    PurchaseDTO save(PurchaseDTO dto);
    Optional<PurchaseDTO> findById(Long id);
    boolean delete(Long id);
    List<PurchaseDTO> findAll();
}
