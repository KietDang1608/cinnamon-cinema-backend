package com.example.cinnamon_cinema_backend.mappers;

import org.mapstruct.Mapper;
import com.example.cinnamon_cinema_backend.dtos.RoleDTO;
import com.example.cinnamon_cinema_backend.entities.Role;
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role role);
    Role toEntity(RoleDTO roleDTO);
}
