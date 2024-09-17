package com.kdu.assessment.service;


import com.kdu.assessment.dto.ItemDTO;
import com.kdu.assessment.entities.Cart;
import com.kdu.assessment.entities.Inventory;
import com.kdu.assessment.exception.custom.InvalidArgumentsException;
import com.kdu.assessment.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void addItem(Cart cart){
        try {
            cartRepository.save(cart);
            log.info("Cart added Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Cart details are invalid");
        }
    }

    public void updateItem(ItemDTO itemDTO){
        try {
            Map<UUID, Integer> items = cartRepository.getReferenceById(itemDTO.getCartID()).getItems();
            items.put(itemDTO.getItemId(), itemDTO.getQuantity());
            if (cartRepository.updateItems(itemDTO.getCartID(), items)==0){
                throw new InvalidArgumentsException("Invalid cart id");
            }
            log.info("Cart updated Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Error while updating cart");
        }
    }

    public void deleteCart(UUID inventoryId){
        try{
            cartRepository.delete(cartRepository.getReferenceById(inventoryId));
            log.info("Cart deleted Successfully");
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Cart id is invalid");
        }
    }

    public Cart getCart(UUID cartID){
        try{
            return cartRepository.getReferenceById(cartID);
        }
        catch (Exception exception){
            throw new InvalidArgumentsException("Cart id is invalid");
        }
    }
}
