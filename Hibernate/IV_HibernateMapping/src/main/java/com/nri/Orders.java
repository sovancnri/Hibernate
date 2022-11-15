package com.nri;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblorder")
public class Orders {
	
	@Id
	@Column(name="orderid")
	private int ordid;
	
	@Column(name="ordername")
	private String ordname;
	
	@Column(name="orderprice")
	private double ordprice;
	
	
	@ManyToMany
	private List<Customer> customer;
	
	public Orders() {
		super();
	}
	
	public int getOrdid() {
		return ordid;
	}
	
	

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	
	public String getOrdname() {
		return ordname;
	}
	
	public void setOrdname(String ordname) {
		this.ordname = ordname;
	}
	
	public double getOrdprice() {
		return ordprice;
	}
	
	public void setOrdprice(double ordprice) {
		this.ordprice = ordprice;
	}
	
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", ordname=" + ordname + ", ordprice=" + ordprice + ", customer=" + customer
				+ "]";
	}
}
