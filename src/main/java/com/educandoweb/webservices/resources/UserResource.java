package com.educandoweb.webservices.resources;

import com.educandoweb.webservices.entities.User;
import com.educandoweb.webservices.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @ApiOperation(value = "Insere usuário")
    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
