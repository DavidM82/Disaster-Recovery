<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
    <title>Spring3MVC with Hibernate3 CRUD Example using Annotations</title>
  </head>
  <body>
    <h2>Disaster Recovery Login</h2>
    <div class="container">
    <form:form method="POST" action="login.html">
	   		<table>
			    <tr>
			    	<td><form:label path="username">Username:</form:label></td>
			    	<td><form:input path="username"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">Password:</form:label></td>
			        <td><form:input path="password" type="password"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
</html>