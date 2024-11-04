package dev.project.userstest.mapper;

import dev.project.userstest.dto.VendorDTO;
import dev.project.userstest.persistence.entity.Vendor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    @Mapping(source = "id", target = "vendorID")
    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "name2", target = "lastName")
    VendorDTO toDTO(Vendor vendor);

    @InheritInverseConfiguration
    Vendor toEntity(VendorDTO dto);

    List<VendorDTO> toDTOList(List<Vendor> vendors);

    List<Vendor> toEntityList(List<VendorDTO> vendorDTOS);
}
