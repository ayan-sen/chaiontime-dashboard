package com.dashboard.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_DETAILS_ID")
	private Long orderDetailsId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "UNIT")
	private String unit;
	
	@Column(name = "UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name = "TOTAL_PRICE")
	private Double totalPrice;
	
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name = "ORDER_ID", insertable=false, updatable=false)
	private Order orderHeader;

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Order getOrderHeader() {
		return orderHeader;
	}

	public void setOrderHeader(Order orderHeader) {
		this.orderHeader = orderHeader;
	}
}
