package com.nri;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	private int lappyid;
	private String lappyname;
	public int getLappyid() {
		return lappyid;
	}
	public void setLappyid(int lappyid) {
		this.lappyid = lappyid;
	}
	public String getLappyname() {
		return lappyname;
	}
	public void setLappyname(String lappyname) {
		this.lappyname = lappyname;
	}
	@Override
	public String toString() {
		return "Laptop [lappyid=" + lappyid + ", lappyname=" + lappyname + "]";
	}
	
}
