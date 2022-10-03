package com.example.sinaukoding.Service;

import  com.example.sinaukoding.Entity.Users;
import com.example.sinaukoding.Entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findByUsername(String username);

    List<UserDTO> getAllData();
}
