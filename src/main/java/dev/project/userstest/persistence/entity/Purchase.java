package dev.project.userstest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Purchase", schema = "application")
public class Purchase {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_gen")
    @SequenceGenerator(name = "sale_gen", sequenceName = "sale_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendorID", nullable = false)
    private Vendor vendor;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<PurchaseItem> items;
}
