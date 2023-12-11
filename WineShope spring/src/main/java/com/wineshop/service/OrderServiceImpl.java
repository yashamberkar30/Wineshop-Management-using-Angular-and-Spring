package com.wineshop.service;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wineshop.exception.ResourceNotFoundException;
import com.wineshop.model.Cart;
import com.wineshop.model.Customer;
import com.wineshop.model.Order;
import com.wineshop.repository.CartRepository;
import com.wineshop.repository.OrderRepository;
import com.wineshop.serviceinterface.CartService;
import com.wineshop.serviceinterface.CustomerService;
import com.wineshop.serviceinterface.OrderService;
import com.wineshop.serviceinterface.ProductService;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepository orderRepository;

	@Autowired
	public ProductService productService;

	@Autowired
	public CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartRepository c;

	public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, CartService cartService,
			CustomerService customerService) {
		super();
		this.orderRepository = orderRepository;
		this.productService = productService;
		// this.cartService = cartService;
		this.customerService = customerService;
	}

	@Override
	public Order addOrder(Order order, long customerId, long cartId) {
		// Cart cart=cartService.getCartById(cartId);
		// Product product=productService.getProductByProductId(productId);
		Cart cart = cartService.getCartById(cartId);
		// order.setCart(cart);
		// System.out.println("cart"+cart);
		Customer customer = customerService.getCustomerById(customerId);
		// order.setPrice(cartId);
		order.setTotalPrice(order.getmrpPrice() * cart.getQuantity());
		order.setPaymentStatus(order.getPaymentStatus());
		order.setOrderStatus(order.getOrderStatus());
		order.setOrderedDate(order.getOrderedDate());
		order.setPrice(cart.getMrpPrice());
		order.setQuantity(cart.getQuantity());
		order.setCustomer(customer);
		// order.setCartId(order.getCartId());
		// order.setTotalPrice(order.getTotalPrice());
		Order o = orderRepository.save(order);
		c.deleteById(cartId);
		return o;
	}

	@Override
	public List<Order> getAllOrders() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = new java.util.Date();
		String currentDate = sdf.format(date);
		String[] array = currentDate.split("/");
		int month = Integer.parseInt(array[0]);
		int day = Integer.parseInt(array[1]);
		int year = Integer.parseInt(array[2]);
		java.util.Date d = new java.util.Date(month, day, year);
		System.out.println(d);
		List<Order> orders = orderRepository.findAll();
		System.out.println(orders);
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getOrderByCustomerId(long customerId) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = new java.util.Date();
		String currentDate = sdf.format(date);
		String[] array = currentDate.split("/");
		int month = Integer.parseInt(array[0]);
		int day = Integer.parseInt(array[1]);
		int year = Integer.parseInt(array[2]);
		java.util.Date d = new java.util.Date(month, day, year);
		System.out.println(d);
		List<Order> orders = orderRepository.findByCustomerCustomerId(customerId);
		System.out.println(orders);
		return orderRepository.findByCustomerCustomerId(customerId);
	}

//@Override
//public List<Order> getAllOrdersByCartId(long cartId)
//{
//	return orderRepository.findByCartId(cartId);
//
//}

	@Override
	public Order updateOrder(Order order, long orderId) {
		Order existingOrder = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
		existingOrder.setTotalPrice(order.getmrpPrice());
		// existingOrder.setPrice(order.getPrice());
		existingOrder.setPaymentStatus(order.getPaymentStatus());
		existingOrder.setPrice(order.getmrpPrice());
		existingOrder.setOrderStatus(order.getOrderStatus());
		existingOrder.setCustomer(order.getCustomer());
		// existingOrder.setCartId(order.getCartId());
		existingOrder.setOrderedDate(order.getOrderedDate());
		// existingOrder.setCart(order.getCart());
		orderRepository.save(existingOrder);
		return existingOrder;
	}

	@Override
	public void deleteOrder(long orderId) {
		orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
		orderRepository.deleteById(orderId);

	}

	@Override
	public Order getOrderById(long orderId) {

		return orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));

	}

	@Override
	public Order addOrderItem(Order order, long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		order.setTotalPrice(order.getTotalPrice());
		order.setPaymentStatus(order.getPaymentStatus());
		order.setOrderStatus(order.getOrderStatus());
		order.setOrderedDate(order.getOrderedDate());
		order.setCustomer(customer);
		Order o = orderRepository.save(order);
		return o;
	}

}