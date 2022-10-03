package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Mapping.UserMapping;
import com.example.sinaukoding.Entity.dto.UserDTO;
import com.example.sinaukoding.Repository.UserRepository;
import com.example.sinaukoding.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO findByUsername(String username) {
        return UserMapping.instance.toDto(repository.findByUsername(username));
    }

    @Override
    public List<UserDTO> getAllData() {
        return UserMapping.instance.toListDto(repository.findAll());
    }
}
