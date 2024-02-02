package com.kdu.assessment.service;


import com.kdu.assessment.dto.CheckoutDTO;
import com.kdu.assessment.entities.Cart;
import com.kdu.assessment.entities.Inventory;
import com.kdu.assessment.entities.Order;
import com.kdu.assessment.exception.custom.InvalidArgumentsException;
import com.kdu.assessment.repository.CartRepository;
import com.kdu.assessment.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class OrderService {
    private final AddressService addressService;

    private final InventoryService inventoryService;

    OrderRepository orderRepository;
    CartRepository cartRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, CartRepository cartRepository,
                        AddressService addressService, InventoryService inventoryService){
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.addressService = addressService;
        this.inventoryService = inventoryService;
    }

    private int calculateAmount(Cart cart){
        AtomicInteger amount = new AtomicInteger();

        cart.getItems().forEach((itemId, quantity) -> {
            Inventory item = inventoryService.getItem(itemId);
            amount.addAndGet(item.getPrice() * quantity);
        });

        return amount.get();
    }

    public void placeOrder(CheckoutDTO checkoutDTO){
        Cart cartToCheckout;
        try {
            cartToCheckout = cartRepository.getReferenceById(checkoutDTO.getCartId());
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Invalid cart id");
        }

        Order order = new Order();
        order.setItems(cartToCheckout.getItems());
        order.setUser(cartToCheckout.getUser());
        order.setAmount(calculateAmount(cartToCheckout));
        order.setAddress(addressService.getAddress(checkoutDTO.getAddressId()));

        try {
            orderRepository.save(order);
            log.info("Order Placed successfully");
        }
        catch (Exception ex){
            throw new InvalidArgumentsException("Error while placing order");
        }
    }

}
