<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link  href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact log</title>
</head>
<body>
<h3 align="right"><a href="<c:url value="/logout" />">Logout</a> </h3>
<h2> Contact log</h2>
<table class="table table-bordered table-striped table-hover">
<thead>
	<th>Contact Name</th>
	<th>Contact Address</th>
	<th>Phone Number</th>
	<th>Pincode</th>
	<th></th>
<thead>
<tbody>
	<c:forEach items="${contactList}" var="contact">
		<tr>
			<td><a href="editContactForm?contactname=${contact.contactname}">${contact.contactname }</a></td>
			<td>${contact.contactaddress }</td>
			<td>${contact.phonenumber }</td>
			<td>${contact.pincode }</td>
			<td>
				<sec:authorize access="hasRole('EDITOR')" >
					<a href="deleteProduct/${con.contactname}">Delete</a>
				</sec:authorize>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>