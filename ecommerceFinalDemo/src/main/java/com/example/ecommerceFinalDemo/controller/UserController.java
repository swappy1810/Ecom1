package com.example.ecommerceFinalDemo.controller;


import com.example.ecommerceFinalDemo.dto.UserDto;
import com.example.ecommerceFinalDemo.exception.ApiResponse;
import com.example.ecommerceFinalDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer id){
        UserDto updatedUser = this.userService.updateUser(userDto,id);
        updatedUser.setUser_name(userDto.getUser_name());
        updatedUser.setEmail(userDto.getEmail());
        updatedUser.setPass(userDto.getPass());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer id){
        this.userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserBYId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.userService.getUserById(id));
    }
}
