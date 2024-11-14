package dev.project.userstest.service;

import dev.project.userstest.dto.request.PermissionRequestDTO;
import dev.project.userstest.dto.response.PermissionResponseDTO;
import dev.project.userstest.mapper.PermissionMapper;
import dev.project.userstest.persistence.entity.Permission;
import dev.project.userstest.persistence.repository.PermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    private final PermissionMapper mapper;

    public PermissionServiceImpl(PermissionRepository repository, PermissionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<PermissionResponseDTO> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    @Override
    @Transactional
    public PermissionResponseDTO save(PermissionRequestDTO permission) {
        Permission permissionEntity = mapper.toEntity(permission);
        permissionEntity = repository.save(permissionEntity);

        return mapper.toResponse(permissionEntity);
    }

    @Override
    public List<PermissionResponseDTO> findAll() {
        return mapper.toListResponse(repository.findAll());
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

    @Override
    public List<PermissionResponseDTO> findByUserID(Long userID) {
        return mapper.toListResponse(repository.findByUserID(userID));
    }
}
