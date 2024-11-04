package dev.project.userstest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vendor", schema = "application")
public class Vendor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_gen")
    @SequenceGenerator(name = "vendor_gen", sequenceName = "vendor_seq", schema = "application")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name2")
    private String name2;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "vendor")
    private List<Purchase> purchases;
}
