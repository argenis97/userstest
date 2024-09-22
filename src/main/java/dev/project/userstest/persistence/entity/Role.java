package dev.project.userstest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "application")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
    @SequenceGenerator(name = "role_gen", allocationSize = 4, schema = "application"
        , sequenceName = "role_seq")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "role"
            , cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}
        , fetch = FetchType.EAGER)
    private List<Permission> permissions;

    @OneToMany(mappedBy = "role")
    private List<AppUser> users;
}
