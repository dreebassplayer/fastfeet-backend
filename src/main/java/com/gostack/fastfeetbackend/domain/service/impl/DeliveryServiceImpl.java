package com.gostack.fastfeetbackend.domain.service.impl;

import com.gostack.fastfeetbackend.domain.model.Delivery;
import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.repository.DeliveryRepository;
import com.gostack.fastfeetbackend.domain.service.DeliveryService;
import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.DeliveryRequestDTO;
import com.gostack.fastfeetbackend.exceptions.DeliveryManException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private UserService userService;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DeliveryRequestDTO requestDTO) {
        var user = userService.findById(requestDTO.getUserId());
        userValidation(user);
        var delivery = new Delivery();
        setParams(requestDTO, user, delivery);
        deliveryRepository.save(delivery);
    }

    private void setParams(DeliveryRequestDTO requestDTO, User user, Delivery delivery) {
        delivery.setUser(user);
        delivery.setAddress(requestDTO.getAddress());
        delivery.setCity(requestDTO.getCity());
        delivery.setNeighborhood(requestDTO.getNeighborhood());
        delivery.setPostalCode(requestDTO.getPostalCode());
        delivery.setProductName(requestDTO.getProductName());
        delivery.setState(requestDTO.getState());
        delivery.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        delivery.setSignature(requestDTO.getSignature());
    }


    private void userValidation(User user) {
        if(user.getDeliveryMan().equals(Boolean.FALSE)){
            throw new DeliveryManException("O usuário: "+user.getName()+" não é entregador");
        }
    }


}
