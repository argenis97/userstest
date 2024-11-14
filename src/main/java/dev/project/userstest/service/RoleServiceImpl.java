package dev.project.userstest.service;

import dev.project.userstest.dto.request.RoleRequestDTO;
import dev.project.userstest.dto.response.RoleResponseDTO;
import dev.project.userstest.mapper.RoleMapper;
import dev.project.userstest.persistence.entity.Role;
import dev.project.userstest.persistence.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper mapper;
    private final RoleRepository repository;

    public RoleServiceImpl(RoleMapper mapper, RoleRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public RoleResponseDTO save(RoleRequestDTO role) {
        Role entity = mapper.toRole(role, false);

        entity = repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Override
    public Optional<RoleDTO> update(Long id, RoleDTO role) {
        return Optional.empty();
    }

    protected RoleDTO updateRole(Role entity, RoleDTO dto) {
        entity = mapper.updateRoleValues(dto, true, entity);

        entity = repository.save(entity);

        return mapper.toDTO(entity);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<RoleDTO> findByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<RoleDTO> findAll() {
        return List.of();
    }
}
