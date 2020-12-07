package com.gostack.fastfeetbackend.domain.controller;

import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid UserRequestDTO dto){
        userService.save(dto);
    }

    @PutMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long userId, @RequestBody @Valid UserRequestDTO dto){
        userService.update(userId,dto);
    }


}
