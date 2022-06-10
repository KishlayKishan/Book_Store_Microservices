package com.bridgelabz.orderservices.service;

import com.bridgelabz.orderservices.dto.OrderDTO;
import com.bridgelabz.orderservices.model.Order;

import java.util.List;

public interface IOrderService {

    Order addOrder(OrderDTO dto);

    Order getByID(Integer orderId);

    List<Order> getAll();

    Order updateById(Integer orderId,OrderDTO dto);

    Order deleteById(Integer orderId);

}
