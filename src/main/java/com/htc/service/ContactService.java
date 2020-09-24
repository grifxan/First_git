package com.htc.service;

import java.util.List;

import com.htc.beans.Contact;

public interface ContactService {

	public boolean addContact(Contact contact) ;
	public Contact getContact(String contactname);
	public List<Contact> getContacts();
	public List<Contact> getContacts(String states);
	
	public boolean updateContact(Contact contact) ;
	public boolean deleteContact(String contactname);
}
