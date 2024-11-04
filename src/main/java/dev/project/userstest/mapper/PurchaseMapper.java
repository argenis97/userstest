package dev.project.userstest.mapper;

import dev.project.userstest.dto.PurchaseDTO;
import dev.project.userstest.persistence.entity.Purchase;
import dev.project.userstest.persistence.entity.Vendor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mapping(source = "id", target = "purchaseID")
    @Mapping(expression = "java(purchase.getVendor().getId())", target = "vendorID")
    @Mapping(source = "date", target = "dateTrx")
    PurchaseDTO toDTO(Purchase purchase);

    @InheritInverseConfiguration
    Purchase toEntity(PurchaseDTO dto);

    List<PurchaseDTO> toListPurchase(List<Purchase> purchases);

    @AfterMapping
    default void afterMapping(PurchaseDTO dto, @MappingTarget Purchase purchase) {
        Vendor vendor = new Vendor();
        vendor.setId(dto.getVendorID());

        purchase.setVendor(vendor);

        purchase.getItems().forEach(item -> item.setPurchase(purchase));
    }
}
