package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("UserDTO")
public class UserDTO {
	    private Long id;
	    private String name;
	    private String username;
	    private String email;
	    private String password;
	    private String address;
	    private String phone;
	    private String website;
	    private String company;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		@Override
		public String toString() {
			return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email
					+ ", password=" + password + ", address=" + address + ", phone=" + phone + ", website=" + website
					+ ", company=" + company + "]";
		}
	    
	    
	    
}
