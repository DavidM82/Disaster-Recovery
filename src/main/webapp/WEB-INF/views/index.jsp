<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
    <title>Disaster-Recovery</title>
  </head>
  <body>
  <div class="row2">
    <h2>Disaster Recovery Login</h2>
    <form:form method="POST" action="login.html">
	   		<table>
			    <tr>
			    	<td><form:label path="username" value="">Username:</form:label></td>
			    	<td><form:input path="username" required="required"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">Password:</form:label></td>
			        <td><form:input path="password" type="password" required="required"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input class="button" type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
	</div>	
</body>
</html>