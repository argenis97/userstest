package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    @Query("select usr from AppUser usr inner join usr.role role where role.id = :roleID")
    List<AppUser> findByRoleID(@Param("roleID") Long roleID);

    @Query("select usr from AppUser usr" +
            " inner join usr.role role" +
            " inner join role.permissions permission" +
            " where permission.id = :permissionID")
    List<AppUser> findByPermissionID(@Param("permissionID") Long permissionID);

    Optional<AppUser> findByName(String name);
}
