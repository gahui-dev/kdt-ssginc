package com.jsp.dto;

public class CustomerEntity {

	private int custid;
	private String name;
	private String address;
	private String phone;
	private String jumin;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	@Override
	public String toString() {
		return "{custid=" + custid + ", name=" + name + ", address=" + address + ", Phone=" + phone + ", jumin=" + jumin
				+ "}";
	}
}
