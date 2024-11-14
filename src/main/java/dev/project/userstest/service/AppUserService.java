package dev.project.userstest.service;

import dev.project.userstest.dto.request.UpdateUserRequest;
import dev.project.userstest.dto.request.UserRequestDTO;
import dev.project.userstest.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO save(UserRequestDTO user);
    boolean delete(Long userID);
    Optional<UserResponseDTO> findByID(Long userID);
    List<UserResponseDTO> findByRoleID(Long roleID);
    List<UserResponseDTO> findByPermissionID(Long permissionID);
    Optional<UserResponseDTO> findByName(String name);
    Optional<UserResponseDTO> update(Long id, UpdateUserRequest dto);
}
