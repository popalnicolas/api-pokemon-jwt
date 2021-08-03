package com.example.apipokemonsecure.Webservices.Services;

import com.example.apipokemonsecure.Model.AuthRole;
import com.example.apipokemonsecure.Model.AuthUser;

import java.util.List;

public interface AuthService {
    AuthUser saveUser(AuthUser user);
    AuthRole saveRole(AuthRole role);
    void addRoleToUser(String username, String roleName);
    AuthUser getUser(String username);
    List<AuthUser> getAllUsers();
}
