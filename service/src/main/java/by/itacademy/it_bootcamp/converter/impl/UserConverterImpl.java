package by.itacademy.it_bootcamp.converter.impl;


import by.itacademy.it_bootcamp.converter.UserConverter;
import by.itacademy.it_bootcamp.dto.UserDto;

import by.itacademy.it_bootcamp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter<User, UserDto> {
    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getUserId())
                .fullName(entity.getUserFullName())
                .surName(entity.getUserSurname())
                .patronymic(entity.getUserPatronymic())
                .email(entity.getUserEmail())
                .role(entity.getUserRole())
                .build();
    }

    @Override
    public User toEntity(UserDto dto) {
        return User.builder()
                .userId(dto.getId())
                .userFullName(dto.getFullName())
                .userSurname(dto.getSurName())
                .userPatronymic(dto.getPatronymic())
                .userEmail(dto.getEmail())
                .userRole(dto.getRole())
                .build();
    }
}
