<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="right"><a href="<c:url value="/logout" />">Logout</a>
<h2> Contact Info </h2>
 ${con.contactname} 
 ${con.contactaddress}
 ${con.phonenumber }
 ${con.pincode }
 ${con.states }
</body>
</html>