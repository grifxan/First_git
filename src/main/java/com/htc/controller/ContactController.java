package com.htc.controller;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htc.beans.Contact;
import com.htc.service.ContactService;
//import com.htc.validator.ContactFormValidator;

@Controller
public class ContactController {

	Logger logger =  Logger.getLogger(ContactController.class);

	@Autowired
	ContactService contactService;
	
	//@Autowired
	//ContactFormValidator contactFormValidator;
	
	
	@RequestMapping(value="/contactform", method=RequestMethod.GET)
	public ModelAndView contactform() {
		logger.info("showing contact form");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contactform");
		mv.addObject("contact", new Contact());
		return mv;
	}
	
	@RequestMapping(value = "/addContact", method=RequestMethod.POST)    
	public String addProduct(@ModelAttribute(name="contact") @Valid Contact contact, BindingResult result, RedirectAttributes redirectAttrs, Model model) {

		//contactFormValidator.validate(contact, result);
		if(result.hasErrors()) {
			model.addAttribute("contact", contact);
			return "contactform";
		}
		else {
			logger.info("addContact() method");
			logger.info(contact.toString());
		
			boolean insertStatus = contactService.addContact(contact);
			logger.info(insertStatus);
			if(insertStatus) {
				redirectAttrs.addFlashAttribute("msg", "Contact Added Successfully");
				redirectAttrs.addFlashAttribute("contactName", contact.getContactname());
				return "redirect:/addContactSuccess";
			}
			else
				return "redirect:/addContactFailure";
		}
	}

	@GetMapping(value="/addContactSuccess")
	 public String showSuccess() {
		 return "addContactSuccess";
	 }

	@GetMapping(value="/list")
	public ModelAndView listProducts() {
		
		List<Contact> contactList = contactService.getContacts();
		Collections.sort(contactList);		
		ModelAndView mv = new ModelAndView("listcontact","contactList", contactList);
		return mv;
	}
	
	@GetMapping(value="/editContactForm")
	public ModelAndView editContactForm(@RequestParam(name="contactname") String contactname) {
		logger.info("Param:" + contactname);
		Contact contact = contactService.getContact(contactname);
		ModelAndView mv = new ModelAndView("editContactForm", "contact", contact);
		return mv;
	}
	
	@PostMapping(value="/updateContact")
	public String updateProduct(@ModelAttribute(name="contact") @Valid Contact contact, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("contact-", contact);
			return "editContactForm";
		}
		else {
			logger.info("updatecontact:" + contact.toString());
		
			boolean updateStatus = contactService.updateContact(contact);
			logger.info(updateStatus);
			if(updateStatus) {
				redirectAttrs.addFlashAttribute("msg", "Contact Updated Successfully");
				redirectAttrs.addFlashAttribute("ContactName", contact.getContactname());
				return "redirect:/addContactSuccess";
			}
			else
				return "redirect:/addContactFailure";
		}
	}
	
	@GetMapping(value="/deleteContact/{contactname}")
	public String deleteContact(@PathVariable(name="contactname") String contactname) {
		logger.info("deleteContact-" + contactname);
		boolean result = contactService.deleteContact(contactname);
		if(result) {
			return "redirect:/list";
		}
		else {
			return "deleteFail";
		}
	}


	@GetMapping(value="/searchContactForm")
	public String searchForm() {
		return "searchContactForm";
	}
	

	
	
}
