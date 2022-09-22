package com.demo.authservice.repositories;


import com.demo.authservice.dto.UserRoleDto;
import com.demo.authservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query(value = " select new com.demo.authservice.dto.UserRoleDto(ur.userId, r.roleName)  from UserRole ur " +
                    " inner join Role r on r.id = ur.roleId " +
                    " where ur.userId = :userId group by ur.userId")
    List<UserRoleDto> findByUserId(@Param("userId") int userId);

    void deleteByUserId(int userId);
}
