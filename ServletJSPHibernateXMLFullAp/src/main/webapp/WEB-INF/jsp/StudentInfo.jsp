<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaLive</title>
</head>
<body>
Welcome to my app.
	<br />Details of the student are as follows:<br/>
	<c:out value="${requestScope.Student.getId()}" /><br/>
	<c:out value="${requestScope.Student.getName()}" /><br/>
	<c:out value="${requestScope.Student.getAddress()}" /><br/>
	 <a href = "<c:url value = "/index.jsp"/>">Back to Main Page</a>
</body>
</html>