package com.kdu.assessment.controller;


import com.kdu.assessment.dto.CheckoutDTO;
import com.kdu.assessment.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<String> checkoutOrder(@RequestBody CheckoutDTO checkoutDTO){
        orderService.placeOrder(checkoutDTO);
        return ResponseEntity.ok("Successfully placed order");
    }

}
