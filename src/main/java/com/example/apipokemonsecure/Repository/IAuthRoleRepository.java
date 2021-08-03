package com.example.apipokemonsecure.Repository;

import com.example.apipokemonsecure.Model.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRoleRepository extends JpaRepository<AuthRole, Integer> {
    AuthRole findByRoleName(String name);
}
