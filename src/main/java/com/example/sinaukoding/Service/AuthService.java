package com.example.sinaukoding.Service;

import com.example.sinaukoding.Entity.dto.AuthenticationDTO;
import com.example.sinaukoding.Entity.dto.ResponsAuthDTO;
import com.example.sinaukoding.Entity.dto.UserDTO;
import com.example.sinaukoding.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface AuthService {
    ResponsAuthDTO register(UserDTO data);

    ResponsAuthDTO login(AuthenticationDTO data);
}
