package com.demo.authservice.repositories;

import com.demo.authservice.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRoleName(String roleName);

    @Query("select r.roleName from UserRole ur\n" +
            "inner join Role r on r.id = ur.roleId\n" +
            "where ur.userId = ?1")
    List<String> findRoleNameByUserId(int userId);

}
