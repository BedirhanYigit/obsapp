package com.example.obsapp.service;
import java.util.List;

import com.example.obsapp.dtos.UserDTO;
import com.example.obsapp.entity.UserEntity;
import com.example.obsapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    private UserRepository userRepository;
    private UserEntity userEntity;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public UserEntity createUser(UserDTO userDTO){
         this.userEntity = new UserEntity();
         userEntity.setAge(userDTO.getAge());
         userEntity.setGender(userDTO.getGender());
         userEntity.setHeight(userDTO.getHeight());
         userEntity.setWeight(userDTO.getWeight());
         userEntity.setSurname(userDTO.getSurname());
         userEntity.setName(userDTO.getName());
         return userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        this.userRepository.deleteById(id);
    }

    public UserEntity update(){
        return null;
    }
}



