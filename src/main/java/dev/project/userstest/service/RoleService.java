package dev.project.userstest.service;

import dev.project.userstest.dto.request.RoleRequestDTO;
import dev.project.userstest.dto.response.RoleResponseDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleResponseDTO save(RoleRequestDTO role);
    Optional<RoleResponseDTO> update(Long id, RoleRequestDTO role);
    boolean delete(Long id);
    Optional<RoleResponseDTO> findByID(Long id);
    List<RoleResponseDTO> findAll();
}
