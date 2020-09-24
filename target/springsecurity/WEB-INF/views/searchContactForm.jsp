<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<script src="<c:url value='/resources/js/jquery-2.1.1.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/myscript.js'/>" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="contactform.heading"/></title>
</head>
<body>

<div class="container">
  <h3 align="right"><a href="<c:url value="/logout" />">Logout</a>
  <h2><spring:message code="contactform.heading"/></h2>
  <form id="contactform">
  		<table class="table table-striped">        
			<tr>
			
				<td>
					<label for="contactname">
						<spring:message code="contactform.contactname"/>
					</label>
				</td>
				<td> <input type="text" id="contactname" /> 
					 <button type="button" id="search" class="btn btn-search">Search</button>
					 <br/><span id="contactnameMsg"></span>
				</td>
			</tr>
			<tr>
				<td>
					<label for="contactaddress">
						<spring:message code="contactform.contactaddress"/>
					</label>
				</td>
				<td> <input type="text" id="contactaddress" />
				     <span id="contactaddressMsg"></span>
			     </td>
			</tr>
			<tr>
				<td>
					<label for="phonenumber">
						<spring:message code="contactform.phonenumber"/>
					</label>
				</td>
				<td> <input type="text" id="phonenumber" />
					 <span id="phonenumberMsg"></span>
				 </td>
			</tr>
			<tr>
				<td>
					<label for="pincode">
						<spring:message code="contactform.pincode"/>
					</label>
				
				</td>
				<td><input type="text" id="pincode" />
					<span id="pincodeMsg"></span>
				</td>
			</tr>
			<tr>
				<td>
					<label for="states">
						<spring:message code="contactform.states"/>
					</label>
				</td>
				<td>
					<select id="states">
						<option value="TN">TamilNadu</option>
						<option value="AP">AndraPradesh</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<sec:authorize access="hasRole('EDITOR')">					
        				<button id="uptcntct" type="button" class="btn btn-default"><spring:message code="contactform.edit"/></button>
        			</sec:authorize>
        			<sec:authorize access="hasRole('ADMIN')">
        				<button id="dletcntct" type="button" class="btn btn-default"><spring:message code="contactform.delete"/></button>
        			</sec:authorize>
        			<h2 id="statusMessage"></h2>
    			</td>
			</tr>
		</table>
		
  </form>
  </div>
</body>
</html>