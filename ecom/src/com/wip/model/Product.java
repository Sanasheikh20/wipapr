package com.wip.model;

public class Product {
	private int pid;
	private String pname;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid) {
		super();
		this.pid = pid;

	}

	public Product(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

//	public Product( String pname,int pid) {
//		super();
//		this.pid = pid;
//		this.pname = pname;
//	}
//	public Product(float pid, double pname) {
//		super();
//		
//	}	

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void displayProduct() {
		System.out.println(pid + " -- " + pname);
	}

	private String displayProduct(int pid, String pName) {
		return pid + " -- " + pname;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + "]";
	}

}
