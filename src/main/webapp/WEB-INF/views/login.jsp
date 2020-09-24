<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<spring:url value="/resources/styles/style.css" var="mainCss" />
	<link rel="stylesheet" type="text/css" href="${mainCss}"/>
	<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
</head>
<body>
	<h2>Login Screen</h2> 
	<mvc:form  action="login" method="post">    
		<table>
			<tr>
			<td colspan="2">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">Invalid Username or Password. Please try again!!!</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You Logout successfully !!</div>
			</c:if>
			</td>
			</tr>        
			<tr>
				<td> Username </td>
				<td><input type="text" name="username" id="username"/></td>
			</tr>
			<tr>
				<td> Password</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			
			<tr>
				<td>
				<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
				<input type="submit" value="Sign In"/></td>
			</tr>
		</table>
	</mvc:form>

</body>
</html>
