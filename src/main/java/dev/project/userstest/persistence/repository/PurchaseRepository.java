package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("select p from Purchase p inner join p.items i where i.product.id = :productID")
    List<Purchase> findByProductID(@Param("productID") Long productID);

    @Query("select p from Purchase p where p.vendor.id = :vendorID")
    List<Purchase> findByVendorID(@Param("vendorID") Long vendorID);
}
