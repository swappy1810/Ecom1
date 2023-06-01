package com.example.ecommerceFinalDemo.service;

import com.example.ecommerceFinalDemo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto user,Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    ResponseEntity<UserDto> deleteUser(Integer id);

}
