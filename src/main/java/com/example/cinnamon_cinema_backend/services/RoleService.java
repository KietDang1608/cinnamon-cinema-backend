package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.RoleDTO;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.User;

import java.util.List;

public interface RoleService {

    void assignRoleToUser(User user, Role role);

    boolean userHasRole(User user, Role role);

    RoleDTO createRole(RoleDTO role);

    void deleteRole(Long roleId);

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long id);
    RoleDTO updateRole(Long id, RoleDTO role);

    RoleDTO GetRoleByUserId(Long userId);
}
