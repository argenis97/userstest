package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
