package com.gostack.fastfeetbackend.domain.service;

import com.gostack.fastfeetbackend.domain.model.Delivery;
import com.gostack.fastfeetbackend.dto.DeliveryRequestDTO;

public interface DeliveryService {
    void save( DeliveryRequestDTO requestDTO);
    Delivery findById(Long id);
    void update(Long id, DeliveryRequestDTO requestDTO);
    void delete(Long id);
}
