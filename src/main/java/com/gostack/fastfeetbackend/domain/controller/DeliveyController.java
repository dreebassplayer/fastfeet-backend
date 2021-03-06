package com.gostack.fastfeetbackend.domain.controller;

import com.gostack.fastfeetbackend.domain.model.Delivery;
import com.gostack.fastfeetbackend.domain.service.DeliveryService;
import com.gostack.fastfeetbackend.dto.DeliveryRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/deliveries")
@Api(tags = "Deliveries")
public class DeliveyController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ApiOperation("Salva uma entrega")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void save (@RequestBody @Valid DeliveryRequestDTO dto){
        deliveryService.save(dto);
    }

    @PutMapping("/{deliveryId}")
    @ApiOperation("Atualiza uma entrega por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void update (@RequestBody @Valid DeliveryRequestDTO dto, @PathVariable Long deliveryId){
        deliveryService.update(deliveryId,dto);
    }

    @GetMapping("/{deliveryId}")
    @ApiOperation("Busca uma entrega por id")
    @ResponseStatus(HttpStatus.OK)
    private Delivery findById (@PathVariable Long deliveryId){
       return deliveryService.findById(deliveryId);
    }

    @DeleteMapping("/{deliveryId}")
    @ApiOperation("Exclui uma entrega por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Long deliveryId){
        deliveryService.delete(deliveryId);
    }



}
