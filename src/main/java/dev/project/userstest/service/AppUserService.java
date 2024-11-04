package dev.project.userstest.service;

import dev.project.userstest.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<UserDTO> findAll();
    UserDTO save(UserDTO user);
    boolean delete(Long userID);
    Optional<UserDTO> findByID(Long userID);
    List<UserDTO> findByRoleID(Long roleID);
    List<UserDTO> findByPermissionID(Long permissionID);
    Optional<UserDTO> findByName(String name);
}
