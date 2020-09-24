<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
 <head>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
	<title>Contact Info</title>
 </head>
<body>
<div class="container">
	<div class="jumbotron">
		<h2> Contact Validation Check</h2>
	</div>
	<div class="list-group">
		<a class="list-group-item" href="contactform" style="width:200px">Contact Entry Form</a> <br/>
	    <a class="list-group-item" href="list" style="width:200px">List AllContacts</a> <br/>	    			
	    <a class="list-group-item" href="searchContactForm" style="width:200px">Search Contact</a> <br/>	    			
	</div>            
</div> 
	
</body>
</html>