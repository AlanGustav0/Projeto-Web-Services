package com.educandoweb.webservices.resources;

import com.educandoweb.webservices.entities.Category;
import com.educandoweb.webservices.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Categorias API Controller", produces = MediaType.APPLICATION_JSON_VALUE,
        tags = {"Categorias"})
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Retorna lista de categorias")
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> listOrders = categoryService.findAll();
        return ResponseEntity.ok().body(listOrders);
    }

    @ApiOperation(value = "Retorna categoria por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
