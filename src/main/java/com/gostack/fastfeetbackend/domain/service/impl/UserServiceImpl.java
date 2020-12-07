package com.gostack.fastfeetbackend.domain.service.impl;

import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.repository.UserRepository;
import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserRequestDTO requestDTO) {
        var user = setParams(requestDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(requestDTO.getPassword()).getBytes());
        userRepository.save(user);
    }

    private User setParams(UserRequestDTO requestDTO) {
        var user = new User();
        user.setName(requestDTO.getName());
        user.setCpf(requestDTO.getCpf());
        user.setEmail(requestDTO.getEmail());
        user.setDeliveryMan(requestDTO.getDeliveryMan());
        return  user;
    }
}
