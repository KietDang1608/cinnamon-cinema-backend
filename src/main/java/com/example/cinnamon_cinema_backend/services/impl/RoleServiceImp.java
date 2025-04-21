package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.RoleDTO;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.User;
import com.example.cinnamon_cinema_backend.mappers.RoleMapper;
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
    private final RoleMapper roleMapper;

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
    public RoleDTO createRole(RoleDTO role) {
        log.info("Creating role {}", role.getName());
        // Implement the logic to create a new role
        // For example, you can use a repository to save the role
        Role newRole = roleMapper.toEntity(role);
        Role savedRole = roleRepo.save(newRole);
        return roleMapper.toDTO(savedRole);
    }

    @Override
    public void deleteRole(Long roleId) {
        log.info("Deleting role with ID {}", roleId);
        // Implement the logic to delete a role by its ID
        // For example, you can use a repository to delete the role
        roleRepo.deleteById(roleId);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        log.info("Fetching all roles");
        // Implement the logic to fetch all roles
        // For example, you can use a repository to find all roles
        List<Role> roles = roleRepo.findAll();
        return roles.stream()
                .map(roleMapper::toDTO)
                .toList();
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        log.info("Fetching role with ID {}", id);
        // Implement the logic to fetch a role by its ID
        // For example, you can use a repository to find the role
        Role role = roleRepo.findById(id).orElse(null);
        return role != null ? roleMapper.toDTO(role) : null;
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO role) {
        log.info("Updating role with ID {}", id);
        // Implement the logic to update a role by its ID
        // For example, you can use a repository to find the role and update its properties
        Role existingRole = roleRepo.findById(id).orElse(null);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            Role updatedRole = roleRepo.save(existingRole);
            return roleMapper.toDTO(updatedRole);
        }
        return null;
    }

    @Override
    public RoleDTO GetRoleByUserId(Long userId) {
        log.info("Fetching role by user ID {}", userId);
        // Implement the logic to fetch a role by user ID
        // For example, you can use a repository to find the user and get their role
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            Role role = user.getRole();
            return role != null ? roleMapper.toDTO(role) : null;
        }
        return null;
    }
}
