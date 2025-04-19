package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.User;
import com.example.cinnamon_cinema_backend.repositories.RoleRepo;
import com.example.cinnamon_cinema_backend.repositories.UserRepo;
import com.example.cinnamon_cinema_backend.services.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    @Override
    public void assignRoleToUser(User user, Role role) {
        log.info("Assigning role {} to user {}", role.getName(), user.getUsername());
        // Implement the logic to assign a role to a user
        // For example, you can use a repository to save the user with the assigned role
        user.setRole(role);
        userRepo.save(user);
        roleRepo.save(role);
    }

    @Override
    public boolean userHasRole(User user, Role role) {

        log.info("Checking if user {} has role {}", user.getUsername(), role.getName());
        // Implement the logic to check if a user has a specific role
        // For example, you can compare the user's role with the given role
        return user.getRole().equals(role);
    }

    @Override
    public Role createRole(Role role) {
        log.info("Creating new role: {}", role.getName());
        // Implement the logic to create a new role
        // For example, you can use a repository to save the role
        roleRepo.save(role);
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        log.info("Deleting role with id: {}", roleId);
        // Implement the logic to delete a role
        // For example, you can use a repository to delete the role by its ID
        roleRepo.deleteById(roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        log.info("Fetching all roles");
        // Implement the logic to fetch all roles
        // For example, you can use a repository to find all roles
        return roleRepo.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        log.info("Fetching role with id: {}", id);
        // Implement the logic to fetch a role by its ID
        // For example, you can use a repository to find the role by its ID
        return roleRepo.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        log.info("Updating role with id: {}", id);
        // Implement the logic to update a role
        // For example, you can use a repository to update the role
        Role existingRole = getRoleById(id);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            roleRepo.save(existingRole);
        }
        return existingRole;
    }

    @Override
    public Role GetRoleByUserId(Long userId) {
        log.info("Fetching role for user with id: {}", userId);
        // Implement the logic to fetch a role by user ID
        // For example, you can use a repository to find the role by user ID
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            return user.getRole();
        }
        return null;
    }
}
