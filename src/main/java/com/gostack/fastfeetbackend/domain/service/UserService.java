package com.gostack.fastfeetbackend.domain.service;

import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.dto.UserRequestDTO;

public interface UserService {
    void save(UserRequestDTO requestDTO);
    void update(Long userId, UserRequestDTO requestDTO);
    User findById(Long userId);
    void delete(Long id);
}
