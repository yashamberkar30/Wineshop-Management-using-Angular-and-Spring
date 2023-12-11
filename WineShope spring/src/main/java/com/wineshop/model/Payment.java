package com.wineshop.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment_table")
@SequenceGenerator(name = "generator5", sequenceName = "gen5", initialValue = 500)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator5")
	@Column(name = "payment_id")
	private long paymentId;

	@Column(name = "Total_Price")
	private double totalPrice;

	@Column(name = "Order_Id", unique = true)
	private long orderId;

	@Column(name = "Card_Number")
	@NotEmpty
	@Size(min = 16, max = 16, message = "cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name = "Exp_Year")
	private String expYear;

	@Column(name = "CVV")
	@NotNull
	private int cvv;

	@Column(name = "Paid_Date")
	private LocalDate PaidDate;

	@Column(name = "Paid_Amount", nullable = false)
	private double paidAmount;

	@Column(name = "Payment_Type", nullable = false)
	private String paymentType;

//@Column(name="paid_date")
//private Date paidDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
//	@JoinColumn(name = "order_id")
//	@JsonIgnore
//	private Order order;
	
	
	public Payment() {
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public LocalDate getPaidDate() {
		return PaidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		PaidDate = paidDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setPaymentType(String paymentType) {

		this.paymentType = paymentType;
	}

	public String getPaymentType() {

		return paymentType;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", totalPrice=" + totalPrice + ", orderId=" + orderId
				+ ", cardNumber=" + cardNumber + ", expYear=" + expYear + ", cvv=" + cvv + ", PaidDate=" + PaidDate
				+ ", paidAmount=" + paidAmount + ", paymentType=" + paymentType + ", customer=" + customer + "]";
	}

//	public Payment(long paymentId, double totalPrice, long orderId,
//			@NotEmpty @Size(min = 16, max = 16, message = "cardNumber must contain 16 digits") String cardNumber,
//			String expYear, @NotNull @Size(min = 2, max = 6, message = "cardNumber must contain 6 digits") int cvv,
//			LocalDate paidDate, double paidAmount, String paymentType, Customer customer) {
//		super();
//		this.paymentId = paymentId;
//		this.totalPrice = totalPrice;
//		this.orderId = orderId;
//		this.cardNumber = cardNumber;
//		this.expYear = expYear;
//		this.cvv = cvv;
//		PaidDate = paidDate;
//		this.paidAmount = paidAmount;
//		this.paymentType = paymentType;
//		this.customer = customer;
//	}

	
}