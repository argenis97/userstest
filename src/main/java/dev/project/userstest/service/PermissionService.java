package dev.project.userstest.service;

import dev.project.userstest.dto.request.PermissionRequestDTO;
import dev.project.userstest.dto.response.PermissionResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    Optional<PermissionResponseDTO> findById(Long id);

    public PermissionResponseDTO save(PermissionRequestDTO permission);

    public List<PermissionResponseDTO> findAll();

    public boolean delete(Long id);

    public List<PermissionResponseDTO> findByUserID(Long userID);
}
