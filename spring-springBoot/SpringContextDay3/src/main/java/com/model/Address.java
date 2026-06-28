package com.model;

import java.util.Objects;

public class Address {
	
	
	private String street;
	private String zipcode;
	

	
	public Address(String street) {
		super();
		this.street = street;
	}
	public Address(String street, String zipcode) {
		super();
		this.street = street;
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public int hashCode() {
		return Objects.hash(street, zipcode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(street, other.street) && Objects.equals(zipcode, other.zipcode);
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", zipcode=" + zipcode + "]";
	}
	
	

}
