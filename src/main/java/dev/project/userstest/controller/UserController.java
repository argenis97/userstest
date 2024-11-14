package dev.project.userstest.controller;

import dev.project.userstest.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AppUserService service;

    public UserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDTO> create(@RequestBody UserDTO user) {
        return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> update(@PathVariable("id") Long id, @RequestBody UserDTO user) {
        return service.update(id, user)
                .map(usr -> ResponseEntity.ok().body(usr))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        if (service.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> get(@PathVariable("id") Long id) {
        return service.findByID(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDTO>> getAll() {
        return Optional.of(service.findAll())
                .filter(users -> !users.isEmpty())
                .map(users -> ResponseEntity.ok().body(users))
                .orElse(ResponseEntity.notFound().build());
    }
}
