package by.itacademy.it_bootcamp.controller;

import by.itacademy.it_bootcamp.dto.UserDto;
import by.itacademy.it_bootcamp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserRestController
 *
 * @author Alexander Grigorovich
 * @version 25.03.2022
 */

@RestController
public class UserRestController {

    private static final int PAGE_SIZE = 10;
    private static final String SORT_FIELD = "userEmail";

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers/{pageNumber}")
    public ResponseEntity<List<UserDto>> getProductUser(@PathVariable("pageNumber") int pageNumber) {
        List<UserDto> userDto = userService.findAllPaginated(pageNumber, PAGE_SIZE, SORT_FIELD).toList();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> getQueryResult(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.save(userDto);
        return ResponseEntity.ok(savedUserDto);
   }
//
//    @GetMapping(value = "/getUserById/{administratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public UserDto getUserById(@PathVariable("userId") Integer userId) {
//        UserDto getByIdUser= userService.findUserById(userId);
//        return ResponseEntity.ok(savedUserDto);
//    }
//
//
//    @GetMapping("/deleteUser/{userId}")
//    private String deleteUser(@PathVariable("userId") Integer userId) {
//        userService.deleteUserById(userId);
//        return "Deleted!";
//    }

}


