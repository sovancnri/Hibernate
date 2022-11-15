package com.nri;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblcustomer")
public class Customer {

	@Id
	@Column(name="customerid")
	private int custid;
	
	@Column(name="customername")
	private String custname;
	
	@Column(name="customercity")
	private String custcity;
	
	@ManyToMany
	@JoinTable(name="tblcustord", joinColumns = {@JoinColumn(name="custid")},inverseJoinColumns= {@JoinColumn(name="ordid")})
	private List<Orders> order;
	
	
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public Customer() {
		super();
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustcity() {
		return custcity;
	}
	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custcity=" + custcity + ", order=" + order
				+ "]";
	}
	
	
	
}
