package by.itacademy.it_bootcamp.service.impl;

import by.itacademy.it_bootcamp.converter.UserConverter;
import by.itacademy.it_bootcamp.dao.UserRepository;
import by.itacademy.it_bootcamp.dto.UserDto;
import by.itacademy.it_bootcamp.entity.User;
import by.itacademy.it_bootcamp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author Aliaksandr Hryharovich
 * @version 25.03.2023
 */

@Service

public class UserServiceImpl
        implements UserService {

    private final UserRepository userRepository;

    private final UserConverter<User, UserDto> userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter<User, UserDto> userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userConverter.toDto(userRepository.save(userConverter.toEntity(userDto)));
    }

    @Override
    public Page<UserDto> findAllPaginated(int pageNumber, int pageSize, String sortField) {
        Sort sort = Sort.by(sortField).ascending();
        Pageable paged = PageRequest.of(pageNumber-1, pageSize, sort);
        return userRepository.findAll(paged).map(userConverter::toDto);
    }
}
