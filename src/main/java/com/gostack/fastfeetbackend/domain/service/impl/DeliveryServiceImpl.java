package com.gostack.fastfeetbackend.domain.service.impl;

import com.gostack.fastfeetbackend.domain.model.Delivery;
import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.repository.DeliveryRepository;
import com.gostack.fastfeetbackend.domain.service.DeliveryService;
import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.DeliveryRequestDTO;
import com.gostack.fastfeetbackend.exceptions.DeliveryManException;
import com.gostack.fastfeetbackend.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        setParams(requestDTO, delivery);
        delivery.setUser(user);
        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElseThrow(()->
                new ObjectNotFoundException("Entrega não encontrado para o id: "+id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, DeliveryRequestDTO requestDTO) {
        var currentDelivery = findById(id);
        setParams(requestDTO,currentDelivery);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        deliveryRepository.delete(findById(id));
    }

    private void setParams(DeliveryRequestDTO requestDTO, Delivery delivery) {
        delivery.setAddress(requestDTO.getAddress());
        delivery.setCity(requestDTO.getCity());
        delivery.setNeighborhood(requestDTO.getNeighborhood());
        delivery.setPostalCode(requestDTO.getPostalCode());
        delivery.setProductName(requestDTO.getProductName());
        delivery.setState(requestDTO.getState());
        delivery.setSignature(requestDTO.getSignature());
    }


    private void userValidation(User user) {
        if(user.getDeliveryMan().equals(Boolean.FALSE)){
            throw new DeliveryManException("O usuário: "+user.getName()+" não é entregador");
        }
    }


}
