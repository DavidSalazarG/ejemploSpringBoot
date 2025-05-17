package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Marcamos la clase como controlador REST
@RestController
public class UserController {

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        // Aquí podrías ir a la base de datos o a un servicio para buscar el usuario.
        // Para el ejemplo, creamos uno de forma estática:
        User dummy = new User(id, "Juan Pérez", "juan.perez@example.com");

        // Devolvemos 200 OK con el usuario en el cuerpo
        return ResponseEntity.ok(dummy);
    }

    // Clase interna para el ejemplo
    public static class User {
        private Long id;
        private String name;
        private String email;

        // Constructor, getters y setters
        public User(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        public Long getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public void setId(Long id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
    }
}
