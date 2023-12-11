package com.wineshop.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Order_Table")
@SequenceGenerator(name = "generator6", sequenceName = "gen", initialValue = 1000)

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator6")
	@Column(name = "Order_Id")
	private long orderId;

	@Column(name = "Mrp_Price")
	private double mrpPrice;

	@Column(name = "Quantity")
	private long quantity;

	@Column(name = "Total_Price")
	private double totalPrice;

	@Column(name = "Order_Status")
	private String orderStatus;

	@Column(name = "Payment_Status")
	private String paymentStatus;

	@Column(name = "Ordered_Date")
	private Date orderedDate;

	@NotEmpty(message = "Product name is required.")
	@Column(name = "Product_Name", nullable = false, length = 20)
	private String productname;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
//	@JsonIgnore
	private Customer customer;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Product_Id")
	private List<Product> product;

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Order() {

	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getmrpPrice() {
		return mrpPrice;
	}

	public void setPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", orderedDate="
				+ orderedDate + ", productname=" + productname + ", customer=" + customer + ", product=" + product
				+ "]";
	}

	

	
	}

	
	

