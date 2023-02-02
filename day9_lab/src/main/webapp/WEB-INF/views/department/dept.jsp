<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List</title>
</head>
<body>
	<h2>Department names</h2><br><br>
	<select name="departments">
	<c:forEach var="dept" items="${requestScope.dept_list}">
	<option value="dept">${dept}</option>
	</c:forEach>
	</select>
	
</body>
</html>