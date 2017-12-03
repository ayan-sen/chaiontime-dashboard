package com.dashboard.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PAYMENT")
public class PaymentLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAYMENT_ID")
	private Long paymentId;
	
	@Column(name="SOURCE_PAYMENT_ID")
	private String sourcePaymentId;
	
	@Column(name="SOURCE")
	private String source;
	
	@Column(name="PAYMENT_MODE")
	private String mode;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="PAYMENT_DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDateTime;
	
	@Column(name="PAYMENT_AMOUNT")
	private Double amount;
	
	@Column(name="ORDER_ID")
	private Long orderId;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getSourcePaymentId() {
		return sourcePaymentId;
	}

	public void setSourcePaymentId(String sourcePaymentId) {
		this.sourcePaymentId = sourcePaymentId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
