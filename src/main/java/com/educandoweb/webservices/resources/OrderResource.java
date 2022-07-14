package com.educandoweb.webservices.resources;

import com.educandoweb.webservices.entities.Order;
import com.educandoweb.webservices.services.OrderService;
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

@Api(value = "Pedidos API Controller", produces = MediaType.APPLICATION_JSON_VALUE,
        tags = {"Pedidos"})
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Retorna lista de pedidos")
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> listOrders = orderService.findAll();
        return ResponseEntity.ok().body(listOrders);
    }

    @ApiOperation(value = "Retorna pedido por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
