package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
