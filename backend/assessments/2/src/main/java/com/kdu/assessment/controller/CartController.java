package com.kdu.assessment.controller;

import com.kdu.assessment.dto.ItemDTO;
import com.kdu.assessment.entities.Cart;
import com.kdu.assessment.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping()
    public ResponseEntity<String> addcart(@RequestBody Cart cart){
        cartService.addItem(cart);
        return ResponseEntity.ok("Cart added Successfully");
    }

    @PutMapping()
    public ResponseEntity<String> updatecart(@RequestBody ItemDTO itemDTO){
        cartService.updateItem(itemDTO);
        return ResponseEntity.ok("Cart updated Successfully");
    }
    @DeleteMapping()
    public ResponseEntity<String> deletecart(@RequestBody UUID cartId){
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Cart deleted Successfully");
    }

    @GetMapping()
    public ResponseEntity<Cart> getCart(@RequestBody UUID cartId){
        return ResponseEntity.ok(cartService.getCart(cartId));
    }



}
