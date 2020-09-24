package com.htc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.htc.beans.Contact;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO{
	Logger logger =  Logger.getLogger(ContactDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean saveContact(Contact contact) {
		logger.info("inside dao" + contact);
		return saveContact(contact.getContactname(), contact.getContactaddress(), contact.getPhonenumber(), contact.getPincode(), contact.getStates());
	}

	
	public boolean saveContact(String contactname, String contactaddress, String phonenumber , String  pincode,
			String states) {
		String sql = "insert into contact values(?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, contactname, contactaddress, phonenumber, pincode, states);
		if(result==1) 
			return true;
		return false;
	}

	@Override
	public boolean updateContact(String contactname, String newphonenumber) {
		
		int result = jdbcTemplate.update("update contact set phonenumber = ? where contactname = ?", newphonenumber, contactname);
		if(result==1) 
			return true;

		return false;
	}

	@Override
	public boolean updateContact2(String contactname, String newphonenumber) {
		
		NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("contactname",contactname);
		params.put("newphonenumber", new String(newphonenumber));
		
		int result = namedJdbcTemplate.update("update contact set phonenumber = :newphonenumber where contactname = :contactname", params);
		if(result==1) 
			return true;

		return false;
	}

	
	@Override
	public boolean removeContact(String contactname) {
		
		int result = jdbcTemplate.update("delete from contact where contactname = ?", contactname);
		if(result==1) 
			return true;
		return false;
	}

	@Override
	public Contact getContact(String contactname) {
		Contact c = null;
		try {
		c = jdbcTemplate.queryForObject("select contactname, contactaddress, phonenumber, pincode,states from contact where contactname = ?", 
				new Object[] {contactname} , 
				new RowMapper<Contact>() {
			
					//@Override
						public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
							Contact contact = new Contact();
							contact.setContactname(rs.getString(1));
							contact.setContactaddress(rs.getString(2));
							contact.setPhonenumber(rs.getString(3));
							contact.setPincode(rs.getString(4));
							contact.setStates(rs.getString(5));
							return contact;
						}
				});
		}
		catch(Exception ex) {
			c = null;
		}
		return c;
	}

	@Override
	public List<Contact> getContacts(String states) {
		List<Contact> contactList = jdbcTemplate.query("select contactname, contactaddress, phonenumber, pincode,states from contact where states = ?",
							new Object[] {states}, 
							new RowMapper<Contact>() {

								//@Override
								public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
									Contact contact = new Contact();
									contact.setContactname(rs.getString(1));
									contact.setContactaddress(rs.getString(2));
									contact.setPhonenumber(rs.getString(3));
									contact.setPincode(rs.getString(4));
									contact.setStates(rs.getString(5));
									return contact;

								}
			
		});
		return contactList;
	}

	@Override
	public List<Contact> getContacts(double minlen, double maxlen) {
		List<Contact> contactList = jdbcTemplate.query("select contactname, contactaddress, phonenumber, pincode,states from contact where phonenumber >= ? and phonenumber <=?",
				new Object[] {new Double(minlen), new Double(maxlen)}, 
				new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
				Contact contact = new Contact();
				contact.setContactname(rs.getString(1));
				contact.setContactaddress(rs.getString(2));
				contact.setPhonenumber(rs.getString(3));
				contact.setPincode(rs.getString(4));
				contact.setStates(rs.getString(5));
				return contact;

			}

           });
          return contactList;	
	}

	@Override
	public List<Contact> getContacts2(double minlen, double maxlen) {
		
		NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Double> paramMap = new HashMap<String, Double>();
		paramMap.put("minlen", new Double(minlen));
		paramMap.put("maxlen", maxlen);
		
		List<Contact> contactList = namedJdbcTemplate.query("select contactname, contactaddress, phonenumber, pincode,states from contact where phonenumber >= :minlen and phonenumber <= :maxlen",
				paramMap, 
				new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
				Contact contact = new Contact();
				contact.setContactname(rs.getString(1));
				contact.setContactaddress(rs.getString(2));
				contact.setPhonenumber(rs.getString(3));
				contact.setPincode(rs.getString(4));
				contact.setStates(rs.getString(5));
				return contact;

			}

});
return contactList;
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> contactList = jdbcTemplate.query("select contactname, contactaddress, phonenumber, pincode,states from contact",
				new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int arg1) throws SQLException {
				Contact contact = new Contact();
				contact.setContactname(rs.getString(1));
				contact.setContactaddress(rs.getString(2));
				contact.setPhonenumber(rs.getString(3));
				contact.setPincode(rs.getString(4));
				contact.setStates(rs.getString(5));
				return contact;

			}

         });
        return contactList;
	}

	@Override
	public String getContactName(String contactname) {
		String contactName = jdbcTemplate.queryForObject("select contactaddress from Product where contactname = ?", new Object[] {contactname}, String.class);
		return contactName;
	}

	@Override
	public int getContactCount(String states) {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
										.withFunctionName("GETCONTACTCOUNT");
		
		Integer count = jdbcCall.executeFunction(Integer.class, states);
		return count;
	
	}
	
	
	public void procedureCallDemo(String contactname) {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
										.withProcedureName("GETCONTACTDETAILS")
										.useInParameterNames("cname")
										.declareParameters(
												new SqlParameter("cname", Types.VARCHAR),
												new SqlOutParameter("contactaddress", Types.VARCHAR),
												new SqlOutParameter("phonenumber", Types.VARCHAR)
										);
										
			Map<String, Object> result  = jdbcCall.execute(contactname);
			
			System.out.println(result.get("contactaddress"));
			System.out.println(result.get("phonenumber"));
	}

	@Override
	public boolean Contact(String contactname, String contactaddress, String phonenumber, String pincode,
			String states) {
		// TODO Auto-generated method stub
		return false;
	}

	}
	

