package com.guilherme.ecommerce.dto;

import com.guilherme.ecommerce.entity.Address;
import com.guilherme.ecommerce.entity.Customer;
import com.guilherme.ecommerce.entity.Order;
import com.guilherme.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
