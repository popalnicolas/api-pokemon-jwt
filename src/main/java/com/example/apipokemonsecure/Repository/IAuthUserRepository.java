package com.example.apipokemonsecure.Repository;

import com.example.apipokemonsecure.Model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthUserRepository extends JpaRepository<AuthUser, Integer> {
    AuthUser findByUsername(String username);
}
