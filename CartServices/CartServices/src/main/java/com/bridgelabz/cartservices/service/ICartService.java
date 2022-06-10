package com.bridgelabz.cartservices.service;

import java.util.List;
import javax.validation.Valid;
import com.bridgelabz.cartservices.dto.CartDTO;
import com.bridgelabz.cartservices.model.Cart;
import com.bridgelabz.cartservices.dto.CartDTO;
import com.bridgelabz.cartservices.model.Cart;

public interface ICartService {

    Cart insertToCart(@Valid CartDTO dto);

    List<Cart> getAllCarts();

    Cart getCartByID(Integer cartId);

    Cart updateById(Integer cartId, @Valid CartDTO dto);

    Cart deleteById(Integer cartId);


}
