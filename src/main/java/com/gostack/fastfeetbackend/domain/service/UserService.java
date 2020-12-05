package com.gostack.fastfeetbackend.domain.service;

import com.gostack.fastfeetbackend.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
