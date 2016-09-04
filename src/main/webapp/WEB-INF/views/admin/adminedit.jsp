<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

</head>
<body>

<p>Here you can add a new beer.</p>
<form:form method="POST" modelAttribute="beer" action="${pageContext.request.contextPath}/admin/beers/edit/${beer.id}/process">
<table>
<tbody>
	<tr>
		<td>Piwo:</td>
		<td><form:input path="piwo" value="${beer.piwo}"></form:input></td>
	</tr>
	<tr>
		<td>Pub:</td>
		<td><form:input path="pub" value="${beer.pub}"></form:input></td>
	</tr>
	<tr>
		<td>Link:</td>
		<td><form:input path="link" value="${beer.link}"></form:input></td>
	</tr>
	<tr>
		<td>progress:</td>
		<td><form:input path="progress" value="${beer.progress}"></form:input></td>
	</tr>
	<tr>
		<td>half:</td>
		<td><form:input path="halfprice" value="${beer.halfprice}" ></form:input></td>
	</tr>
	<tr>
		<td>three:</td>
		<td><form:input path="threeprice" value="${beer.threeprice}"></form:input></td>
	</tr>
	<tr>
		<td><input value="Edit" type="submit"></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>
</body>
</html>