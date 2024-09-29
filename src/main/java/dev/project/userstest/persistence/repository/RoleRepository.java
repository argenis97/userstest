package dev.project.userstest.persistence.repository;

import dev.project.userstest.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select role from Role role" +
            " inner join role.users usr" +
            " where usr.id = :userID")
    List<Role> findByUserID(@Param("userID") Long userID);
}
