package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.RoomDTO;
import com.example.cinnamon_cinema_backend.entities.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
     RoomDTO toDTO(Room room);
     Room toEntity(RoomDTO roomDTO);
}
