package com.educandoweb.webservices.repositories;

import com.educandoweb.webservices.entities.Order;
import com.educandoweb.webservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
