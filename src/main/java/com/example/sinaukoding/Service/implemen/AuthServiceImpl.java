package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Config.JwtTokenUtil;
import com.example.sinaukoding.Entity.Mapping.UserMapping;
import com.example.sinaukoding.Entity.Users;
import com.example.sinaukoding.Entity.dto.AuthenticationDTO;
import com.example.sinaukoding.Entity.dto.ResponsAuthDTO;
import com.example.sinaukoding.Entity.dto.UserDTO;
import com.example.sinaukoding.Repository.UserRepository;
import com.example.sinaukoding.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public ResponsAuthDTO register(UserDTO data) {
        Users users = UserMapping.instance.toEntity(data);
        users.setPassword(BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()));

        users = repository.save(users);

        return UserMapping.instance.fromEntityToResponseDto(users);
    }

    @Override
    public ResponsAuthDTO login(AuthenticationDTO data) {
        Users currentUser = repository.findByUsername(data.getUsername());

        ResponsAuthDTO res = UserMapping.instance.fromEntityToResponseDto(currentUser);

        if (currentUser == null){
            return null;
        } else if (currentUser.getPassword() != null && BCrypt.checkpw(data.getPassword(), currentUser.getPassword())) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            res.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return res;
        }

        return null;
    }
    }

