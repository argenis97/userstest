package dev.project.userstest.service;

import dev.project.userstest.dto.UserDTO;
import dev.project.userstest.mapper.UserMapper;
import dev.project.userstest.persistence.entity.AppUser;
import dev.project.userstest.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    public AppUserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<UserDTO> findAll() {
        return mapper.toListUserDTO(repository.findAll());
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO user) {
        AppUser entityUser = mapper.toUser(user);
        return mapper.toDTO(repository.save(entityUser));
    }

    @Override
    @Transactional
    public boolean delete(Long userID) {
        return repository.findById(userID)
                .stream()
                .peek(repository::delete)
                .findFirst()
                .isPresent();
    }

    @Override
    public List<UserDTO> findByRoleID(Long roleID) {
        return mapper.toListUserDTO(repository.findByRoleID(roleID));
    }

    @Override
    public Optional<UserDTO> findByID(Long userID) {
        return repository.findById(userID)
                .map(mapper::toDTO);
    }

    @Override
    public List<UserDTO> findByPermissionID(Long permissionID) {
        return mapper.toListUserDTO(repository.findByPermissionID(permissionID));
    }

    @Override
    public Optional<UserDTO> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDTO);
    }
}
