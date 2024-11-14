package dev.project.userstest.service;

import dev.project.userstest.mapper.VendorMapper;
import dev.project.userstest.persistence.entity.Vendor;
import dev.project.userstest.persistence.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper mapper;
    private final VendorRepository repository;

    public VendorServiceImpl(VendorMapper mapper, VendorRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public VendorDTO save(VendorDTO dto) {

        Vendor vendor = mapper.toEntity(dto);
        vendor = repository.save(vendor);

        return mapper.toDTO(vendor);
    }

    @Override
    public Optional<VendorDTO> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
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
    public List<VendorDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }
}
