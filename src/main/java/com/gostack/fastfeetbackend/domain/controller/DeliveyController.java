package com.gostack.fastfeetbackend.domain.controller;

import com.gostack.fastfeetbackend.domain.service.DeliveryService;
import com.gostack.fastfeetbackend.dto.DeliveryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveyController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void save (@RequestBody @Valid DeliveryRequestDTO dto){
        deliveryService.save(dto);
    }

}
