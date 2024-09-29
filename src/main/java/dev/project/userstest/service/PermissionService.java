package dev.project.userstest.service;

import dev.project.userstest.dto.PermissionDTO;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    Optional<PermissionDTO> findById(Long id);

    public PermissionDTO save(PermissionDTO permission);

    public List<PermissionDTO> findAll();

    public boolean delete(Long id);

    public List<PermissionDTO> findByUserID(Long userID);
}
