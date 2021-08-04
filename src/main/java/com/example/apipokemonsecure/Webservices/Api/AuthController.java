package com.example.apipokemonsecure.Webservices.Api;

import com.example.apipokemonsecure.Model.AuthUser;
import com.example.apipokemonsecure.Webservices.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/users")
    public ResponseEntity<List<AuthUser>> getAllUsers()
    {
        return ResponseEntity.ok().body(authService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody AuthUser user)
    {
        if(authService.getUser(user.getUsername()) == null) {
            authService.saveUser(user);
            authService.addRoleToUser(user.getUsername(), "ROLE_USER");
            user.setPassword("");
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User with this username already exists");
    }
}
