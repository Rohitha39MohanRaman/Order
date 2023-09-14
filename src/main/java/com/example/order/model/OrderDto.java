package com.example.order.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderDto {
private int orderId;
private String orderName;
public OrderDto() {
	super();
}
public OrderDto(int orderId, String orderName) {
	super();
	this.orderId = orderId;
	this.orderName = orderName;
}
@XmlElement
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
@XmlElement
public String getOrderName() {
	return orderName;
}
public void setOrderName(String orderName) {
	this.orderName = orderName;
}
}
