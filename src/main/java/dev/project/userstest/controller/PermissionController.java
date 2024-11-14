package dev.project.userstest.controller;

import dev.project.userstest.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> findById(@PathVariable("id") Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PermissionDTO> create(@RequestBody PermissionDTO permission) {
        return new ResponseEntity<>(service.save(permission), HttpStatus.CREATED);
    }
}
