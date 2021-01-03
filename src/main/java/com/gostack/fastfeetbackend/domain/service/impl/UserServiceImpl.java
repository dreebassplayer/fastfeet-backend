package com.gostack.fastfeetbackend.domain.service.impl;

import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.repository.UserRepository;
import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.UserRequestDTO;
import com.gostack.fastfeetbackend.exceptions.ObjectNotFoundException;
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
        var user = new User();
        setParams(requestDTO, user);
        user.setPassword(new BCryptPasswordEncoder().encode(requestDTO.getPassword()).getBytes());
        userRepository.save(user);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long userId, UserRequestDTO requestDTO) {
        var userCurrent = findById(userId);
        setParams(requestDTO, userCurrent);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->
                new ObjectNotFoundException("Usuário não encontrado para o id: "+userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }


    private void setParams(UserRequestDTO requestDTO, User user) {
        user.setName(requestDTO.getName());
        user.setCpf(requestDTO.getCpf());
        user.setEmail(requestDTO.getEmail());
        user.setDeliveryMan(requestDTO.getDeliveryMan());
    }

}
