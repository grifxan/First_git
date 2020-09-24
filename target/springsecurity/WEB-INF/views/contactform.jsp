<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link  href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><spring:message code="contactform.heading"/></title>
</head>
<body>

<div class="container">
  <h2>
  <img alt="" src="<c:url value='/resources/images/image.jpeg'/>" />
  <h3 align="right"><a href="<c:url value="/logout" />">Logout</a>
  <spring:message code="contactform.heading"/></h2>
  <mvc:form cssClass="form-horizontal" modelAttribute="contact" action="addContact" method="post">
  		<table class="table table-striped">        
			<tr>
				<td>
					<mvc:label path="contactname">
						<spring:message code="contactform.contactname"/>
					</mvc:label>
				</td>
				<td><mvc:input path="contactname" /></td>
				<td><mvc:errors path="contactname" cssClass="alert alert-danger"/></td>
			</tr>
			<tr>
				<td>
					<mvc:label path="contactaddress">
						<spring:message code="contactform.contactaddress"/>
					</mvc:label>
				</td>
				<td><mvc:input path="contactaddress" /></td>
				<td><mvc:errors path="contactaddress" cssClass="alert alert-danger"/></td>
			</tr>
			<tr>
				<td>
					<mvc:label path="phonenumber">
						<spring:message code="contactform.phonenumber"/>
					</mvc:label>
				</td>
				<td><mvc:input path="phonenumber" /></td>
				<td><mvc:errors path="phonenumber" cssClass="alert alert-danger"/></td>
			</tr>
			<tr>
				<td>
					<mvc:label path="pincode">
						<spring:message code="contactform.pincode"/>
					</mvc:label>
				</td>
				<td><mvc:input path="pincode" /></td>
				<td><mvc:errors path="pincode" cssClass="alert alert-danger"/></td>
			</tr>
			<tr>
				<td>
					<mvc:label path="states">
						<spring:message code="contactform.states"/>
					</mvc:label>
				</td>
				<td>
					<mvc:select path="states">
						<mvc:option value="TN">TamilNadu</mvc:option>
						<mvc:option value="AP">AndraPradesh</mvc:option>
					</mvc:select>
				</td>
				<td> </td>
			</tr>
			<tr>
				<td></td>
				<td>
        			<button type="submit" class="btn btn-default"><spring:message code="contactform.submit"/></button>
        			<button type="reset" class="btn btn-default"><spring:message code="contactform.clear"/></button>
    			</td>
    			<td></td>  
			</tr>
		</table>
  </mvc:form>
  </div>
</body>
</html>