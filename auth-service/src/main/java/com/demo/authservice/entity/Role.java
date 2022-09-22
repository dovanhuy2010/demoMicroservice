package com.demo.authservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String roleName;

//    @Transient
//    @OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY)
//    private List<UserRole> userRoleList;

    @Override
    public String toString() {
        return roleName;
    }
}
