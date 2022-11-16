package com.nri;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library 
{
	@Id
    private int libid;
    private String libname;
    private int libfee;
	public int getLibid() {
		return libid;
	}
	public void setLibid(int libid) {
		this.libid = libid;
	}
	public String getLibname() {
		return libname;
	}
	public void setLibname(String libname) {
		this.libname = libname;
	}
	public int getLibfee() {
		return libfee;
	}
	public void setLibfee(int libfee) {
		this.libfee = libfee;
	}
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Library [libid=" + libid + ", libname=" + libname + ", libfee=" + libfee + "]";
	}
    
    
    
}
