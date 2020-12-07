package com.gostack.fastfeetbackend.domain.service;

import com.gostack.fastfeetbackend.dto.UserRequestDTO;

public interface UserService {
    void save(UserRequestDTO requestDTO);
    void update(Long userId, UserRequestDTO requestDTO);
}
