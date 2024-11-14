package dev.project.userstest.mapper;

import dev.project.userstest.persistence.entity.Purchase;
import dev.project.userstest.persistence.entity.Vendor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

}
