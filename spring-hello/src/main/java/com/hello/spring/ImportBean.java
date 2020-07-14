package com.hello.spring;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/7/14 8:28
 */
public class ImportBean {

	private String username;
	private String address;

	@Override
	public String toString() {
		return "ImportBean{" +
				"username='" + username + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
