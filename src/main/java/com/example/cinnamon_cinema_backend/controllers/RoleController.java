package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.RoleDTO;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        RoleDTO role = roleService.getRoleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO role) {
        RoleDTO createdRole = roleService.createRole(role);
        return ResponseEntity.status(201).body(createdRole);
    }

    @PutMapping ( "/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO role) {
        RoleDTO updatedRole = roleService.updateRole(id, role);
        if (updatedRole != null) {
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<RoleDTO> getRolesByUserId(@PathVariable Long userId) {
        RoleDTO role = roleService.GetRoleByUserId(userId);
        return ResponseEntity.ok(role);
    }


}
