package com.htc.beans;

import javax.validation.constraints.NotEmpty;

public class Contact  implements Comparable<Contact>{
	
	@NotEmpty(message="{contactform.name.empty}" )
	private String contactname;
	@NotEmpty(message="{contactform.address.empty}" )
	private String contactaddress;
	
	private String phonenumber;
	
	private String pincode;
	
	private String states;
	
	public Contact() {}

	public Contact(String contactname, String contactaddress, String phonenumber, String pincode, String states) {
		super();
		this.contactname = contactname;
		this.contactaddress = contactaddress;
		this.phonenumber = phonenumber;
		this.pincode = pincode;
		this.states = states;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactaddress() {
		return contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Contact [contactname=" + contactname + ", contactaddress=" + contactaddress + ", phonenumber="
				+ phonenumber + ", pincode=" + pincode + ", states=" + states + "]";
	}
	
	@Override
	public int compareTo(Contact c) {
		return c.getContactname().compareTo(this.getContactname());
	}

}
