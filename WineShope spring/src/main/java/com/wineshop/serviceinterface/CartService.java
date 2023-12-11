package com.wineshop.serviceinterface;

import java.util.List;

import com.wineshop.model.Cart;
import com.wineshop.model.Customer;

public interface CartService {

	Cart addCart(Cart cart, long productId, long customerId);

	List<Cart> getAllCarts();

	Cart getCartById(long cartId);

	Cart updateCart(Cart cart, long cartId);

	void deleteCart(long cartId);

	void deleteCartByCustomer(Customer c);

}