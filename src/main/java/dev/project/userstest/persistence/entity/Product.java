package dev.project.userstest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "application", name = "Product")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(schema = "application", name = "product_gen", sequenceName = "product_seq")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
}
