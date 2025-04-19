package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.User;

import java.util.List;

public interface RoleService {

    void assignRoleToUser(User user, Role role);

    boolean userHasRole(User user, Role role);

    Role createRole(Role role);

    void deleteRole(Long roleId);

    List<Role> getAllRoles();

    Role getRoleById(Long id);
    Role updateRole(Long id, Role role);

    Role GetRoleByUserId(Long userId);
}
