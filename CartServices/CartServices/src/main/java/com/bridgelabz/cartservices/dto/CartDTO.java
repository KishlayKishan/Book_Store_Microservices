package com.bridgelabz.cartservices.dto;

import lombok.Data;

@Data
public class CartDTO {
    private int userId;
    private int bookId;
    private int quantity;
    private Integer cartID;

}
