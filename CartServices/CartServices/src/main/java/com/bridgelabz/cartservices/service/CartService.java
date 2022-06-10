package com.bridgelabz.cartservices.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bridgelabz.cartservices.dto.CartDTO;
import com.bridgelabz.cartservices.exceptions.CartException;
import com.bridgelabz.cartservices.model.Cart;
import com.bridgelabz.cartservices.repository.CartRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService implements ICartService{

    @Autowired
    CartRepository repo;

    @Autowired
    RestTemplate restTemplate;

    //to insert items in cart
    @Override
    public Cart insertToCart(@Valid CartDTO dto) {
        Cart cart = new Cart(dto);
        repo.save(cart);
        return cart;
    }

    //to get all carts in bookstore app
    @Override
    public List<Cart> getAllCarts() {
        List<Cart> list = repo.findAll();
        if(list.isEmpty()) {
            throw new NullPointerException("there are no Carts inserted yet");
        }
        return list;
    }

    //find cart by cart id
    @Override
    public Cart getCartByID(Integer cartId) {
        Optional<Cart> cart = repo.findById(cartId);
        if(cart.isEmpty()) {
            throw new CartException("There are no carts with given id");
        }
        return cart.get();
    }

    //update cart by cart id
    @Override
    public Cart updateById(Integer cartId, @Valid CartDTO dto) {
        Optional<Cart> cart = repo.findById(cartId);
        if(cart.isPresent()) {
            Cart newCart = new Cart(cartId,dto);
            repo.save(newCart);
            return newCart;
        }
        else {
            throw new CartException("cart not found");
        }
    }

    @Override
    public Cart deleteById(Integer cartId) {
        Optional<Cart> cart = repo.findById(cartId);
        if(cart.isEmpty()) {
            throw new CartException("Invalid CartID..please input valid Id");
        }
        repo.deleteById(cartId);
        return cart.get();
    }

}