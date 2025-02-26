package com.example.obsapp.controller;

import com.example.obsapp.dtos.UserDTO;
import com.example.obsapp.entity.UserEntity;
import com.example.obsapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostExchange("/post")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetExchange("/getAll")
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @DeleteExchange("/delete/{id}")
    public void deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

    }

}
