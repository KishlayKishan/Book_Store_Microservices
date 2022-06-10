package com.bridgelabz.cartservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.cartservices.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}