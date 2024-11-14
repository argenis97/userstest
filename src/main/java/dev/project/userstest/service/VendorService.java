package dev.project.userstest.service;

import java.util.List;
import java.util.Optional;

public interface VendorService {
    VendorDTO save(VendorDTO dto);
    Optional<VendorDTO> findById(Long id);
    boolean delete(Long id);
    List<VendorDTO> findAll();
}
