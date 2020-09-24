package com.htc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.beans.Contact;
import com.htc.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactDAO contactDAO;
	
	Logger logger =  Logger.getLogger(ContactServiceImpl.class);
	
	public boolean addContact(Contact contact) {
		logger.info("Inside service class");
		logger.info("From Service:" + contact);
		
		return contactDAO.saveContact(contact);
	}

	@Override
	public Contact getContact(String contactname) {
		logger.info("getContact()" + contactname);
		
		return contactDAO.getContact(contactname);
	}

	@Override
	public List<Contact> getContacts() {
		logger.info("getContacts()");
		return contactDAO.getContacts();
	}

	@Override
	public List<Contact> getContacts(String states) {
		logger.info("getContact()" + states);
		return contactDAO.getContacts(states);
	}

	@Override
	public boolean updateContact(Contact contact) {
		logger.info("updateContact" + contact);
		return contactDAO.updateContact(contact.getContactname(), contact.getPhonenumber());
	}

	@Override
	public boolean deleteContact(String contactname) {
		logger.info("remove contact" + contactname);
		return contactDAO.removeContact(contactname);
	}

	
}
