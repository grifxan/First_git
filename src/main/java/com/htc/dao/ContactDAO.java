package com.htc.dao;

import java.util.List;

import com.htc.beans.Contact;

public interface ContactDAO {

	public boolean saveContact(Contact contact);
	public boolean Contact(String contactname, String contactaddress, String phonenumber, String pincode, String states);
	public boolean updateContact(String contactname, String newphonenumber);
	public boolean updateContact2(String contactname, String newphonenumber);
	
	public boolean removeContact(String contactname);
	
	public Contact getContact(String contactname);
	
	public List<Contact> getContacts(String states);
	public List<Contact> getContacts(double minlen, double maxlen);
	public List<Contact> getContacts2(double minlen, double maxlen);
	public List<Contact> getContacts();
	
	public String getContactName(String contactname);
	
	public int getContactCount(String states);

	
	
}
