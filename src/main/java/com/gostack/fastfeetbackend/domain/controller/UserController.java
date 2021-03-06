package com.gostack.fastfeetbackend.domain.controller;

import com.gostack.fastfeetbackend.domain.model.User;
import com.gostack.fastfeetbackend.domain.service.UserService;
import com.gostack.fastfeetbackend.dto.UserRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
@Api(tags = "Usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation("Salva um usuário")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody @Valid UserRequestDTO dto){
        userService.save(dto);
    }

    @PutMapping(value = "/{userId}")
    @ApiOperation("Atualiza um usuário por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long userId, @RequestBody @Valid UserRequestDTO dto){
        userService.update(userId,dto);
    }

    @GetMapping(value = "/{userId}")
    @ApiOperation("Busca um usuário por id")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @DeleteMapping(value = "/{userId}")
    @ApiOperation("Exclui um usuário por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }

}
