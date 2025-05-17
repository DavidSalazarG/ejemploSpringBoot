package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class UserController {

    // Lista de usuarios dummy para el ejemplo
    private static final List<User> USERS = List.of(
        new User(1L, "Ana García",      "ana.garcia@example.com"),
        new User(2L, "Carlos Ruiz",     "carlos.ruiz@example.com"),
        new User(3L, "María López",     "maria.lopez@example.com"),
        new User(4L, "Pedro Martínez",  "pedro.martinez@example.com"),
        new User(5L, "Lucía Fernández", "lucia.fernandez@example.com")
    );

    /**
     * GET /user?id={id}
     * Devuelve el usuario cuyo id coincida con el parámetro.
     * Si no se encuentra, devuelve 404 Not Found.
     */
    @GetMapping("/user")
    public ResponseEntity<User> getUserByQuery(@RequestParam("id") Long id) {
        Optional<User> match = USERS.stream()
                                    .filter(u -> u.getId().equals(id))
                                    .findFirst();

        return match
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
