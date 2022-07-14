package com.educandoweb.webservices.resources;

import com.educandoweb.webservices.entities.Product;
import com.educandoweb.webservices.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Produtos API Controller", produces = MediaType.APPLICATION_JSON_VALUE,
        tags = {"Produtos"})
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Retorna lista de produtos")
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> listProducts = productService.findAll();
        return ResponseEntity.ok().body(listProducts);
    }

    @ApiOperation(value = "Retorna produto por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
