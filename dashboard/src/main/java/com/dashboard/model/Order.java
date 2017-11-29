package com.dashboard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDER_HEADER")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;  	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="USER_ID")
	private String userId;
	
//	@JsonIgnore
//	@NotFound(action=NotFoundAction.IGNORE)
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID",insertable=false,updatable=false)
//	private User orderUser;
	
	@Column(name="ORDER_TOTALPRICE")
	private Double totalPrice;
	
	@Column(name="DELIVERY_ADDRESS")
	private String deliveryAddres;
	
	@Column(name="VENDOR_ID")
	private Long venodrId;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VENDOR_ID",insertable=false,updatable=false)
	private Vendor orderVendor;
	
	@Column(name="DELIVERYBOY_ID")
	private Long deliveryPersonId;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DELIVERYBOY_ID", referencedColumnName="DELIVERYBOY_ID",insertable=false,updatable=false)
	private DeliveryPerson orderDeliveryPerson;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="IS_PAID")
	private int isPaid;
	
	@Column(name="DELIVERY_CHARGES")
	private Double deliveryCharges;
	
	@Column(name="TOTAL_ITEMS")
	private int totalItems;
	
	@Column(name="NOTES")
	private String notes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DEIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name="DELIVERY_LAT")
	private String latitude;
	
	@Column(name="DELIVERY_LON")
	private String longitude;
	
	@Column(name="POS_ID")
	private Long posId;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="POS_ID",insertable=false,updatable=false)
	private PointOfSale orderPos;

	@OneToMany(mappedBy = "orderHeader", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryAddres() {
		return deliveryAddres;
	}

	public void setDeliveryAddres(String deliveryAddres) {
		this.deliveryAddres = deliveryAddres;
	}

	public Long getVenodrId() {
		return venodrId;
	}

	public void setVenodrId(Long venodrId) {
		this.venodrId = venodrId;
	}

	public Vendor getOrderVendor() {
		return orderVendor;
	}

	public void setOrderVendor(Vendor orderVendor) {
		this.orderVendor = orderVendor;
	}

	public Long getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public void setDeliveryPersonId(Long deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}

	public DeliveryPerson getOrderDeliveryPerson() {
		return orderDeliveryPerson;
	}

	public void setOrderDeliveryPerson(DeliveryPerson orderDeliveryPerson) {
		this.orderDeliveryPerson = orderDeliveryPerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(int isPaid) {
		this.isPaid = isPaid;
	}

	public Double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(Double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}

	public PointOfSale getOrderPos() {
		return orderPos;
	}

	public void setOrderPos(PointOfSale orderPos) {
		this.orderPos = orderPos;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
