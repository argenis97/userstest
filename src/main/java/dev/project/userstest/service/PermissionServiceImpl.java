package dev.project.userstest.service;

import dev.project.userstest.dto.PermissionDTO;
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
    public Optional<PermissionDTO> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Override
    @Transactional
    public PermissionDTO save(PermissionDTO permission) {
        Permission permissionEntity = mapper.toPermission(permission);
        permissionEntity = repository.save(permissionEntity);

        return mapper.toDTO(permissionEntity);
    }

    @Override
    public List<PermissionDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
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
    public List<PermissionDTO> findByUserID(Long userID) {
        return mapper.toDTOList(repository.findByUserID(userID));
    }
}
