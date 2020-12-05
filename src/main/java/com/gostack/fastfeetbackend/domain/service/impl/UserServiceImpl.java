package com.gostack.fastfeetbackend.domain.service.impl;

import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.repository.UserRepository;
import com.gostack.fastfeetbackend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
