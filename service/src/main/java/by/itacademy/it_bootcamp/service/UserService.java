package by.itacademy.it_bootcamp.service;

import by.itacademy.it_bootcamp.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


/**
 * interface UserService
 *
 * @author Aliaksandr Hryharovich
 * @version 25.03.2023
 */


public interface UserService {
    UserDto save(UserDto userDto);

    Page<UserDto> findAllPaginated(int pageNumber, int pageSize, String sortField);

}
