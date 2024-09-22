package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("select perm from Permission perm" +
            " inner join perm.role role" +
            " inner join role.users usr" +
            " where usr.id = :userID")
    public List<Permission> findByUserID(@Param("userID") Long userID);
}
