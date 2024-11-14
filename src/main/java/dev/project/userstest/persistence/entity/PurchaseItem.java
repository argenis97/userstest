package dev.project.userstest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PurchaseItem", schema = "application")
public class PurchaseItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_gen")
    @SequenceGenerator(name = "item_gen", sequenceName = "item_seq", schema = "application")
    private Long id;

    @Column(name = "qty")
    private BigDecimal qty;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchaseID", nullable = false)
    private Purchase purchase;
}
