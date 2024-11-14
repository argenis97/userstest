package dev.project.userstest.service;

import dev.project.userstest.dto.request.UpdateUserRequest;
import dev.project.userstest.dto.request.UserRequestDTO;
import dev.project.userstest.dto.response.UserResponseDTO;
import dev.project.userstest.mapper.UserMapper;
import dev.project.userstest.persistence.entity.AppUser;
import dev.project.userstest.persistence.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public AppUserServiceImpl(UserMapper mapper, UserRepository repository, BCryptPasswordEncoder encoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return mapper.toListResponse(repository.findAll());
    }

    @Override
    @Transactional
    public UserResponseDTO save(UserRequestDTO user) {
        AppUser entityUser = mapper.toEntity(user);
        entityUser.setPassword(encoder.encode(user.getPassword()));

        return mapper.toResponse(repository.save(entityUser));
    }

    @Override
    @Transactional
    public Optional<UserResponseDTO> update(Long id, UpdateUserRequest dto) {
        return repository.findByIdLazy(id)
                .map(user -> update(user, dto));
    }

    protected UserResponseDTO update(AppUser user, UpdateUserRequest dto) {
        mapper.updateValues(dto, user);

        if (StringUtils.hasText(dto.getPassword()))
            user.setPassword(encoder.encode(dto.getPassword()));

        return mapper.toResponse(repository.save(user));
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
    public List<UserResponseDTO> findByRoleID(Long roleID) {
        return mapper.toListResponse(repository.findByRoleID(roleID));
    }

    @Override
    public Optional<UserResponseDTO> findByID(Long userID) {
        return repository.findById(userID)
                .map(mapper::toResponse);
    }

    @Override
    public List<UserResponseDTO> findByPermissionID(Long permissionID) {
        return mapper.toListResponse(repository.findByPermissionID(permissionID));
    }

    @Override
    public Optional<UserResponseDTO> findByName(String name) {
        return repository.findByName(name)
                .map(mapper::toResponse);
    }
}
