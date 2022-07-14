package com.educandoweb.webservices.resources;

import com.educandoweb.webservices.entities.User;
import com.educandoweb.webservices.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
@Api(value = "User API Controller", produces = MediaType.APPLICATION_JSON_VALUE,
        tags = {"Usuário"})
public class UserResource {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Retorna lista de usuários")
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> listUsers = userService.findAll();
        return ResponseEntity.ok().body(listUsers);
    }

    @ApiOperation(value = "Retorna usuário por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
