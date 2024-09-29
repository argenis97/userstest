package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    @Query("select usr from AppUser usr inner join usr.role role where role.id = :roleID")
    public List<AppUser> findByRoleID(@Param("roleID") Long roleID);
}
