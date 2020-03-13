<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Add/Edit Machine Code</title>
</head>
<body>
<h2>Add A Machine Code</h2>
		<form:form method="POST" action="machineCode.html">
	   		<table>
			    <tr>
			        <form:hidden path="machineCodeId" value="${machineCode.machineCodeId}"/>
			    </tr>
			    <tr>
			    	<td><form:label path="machineCode">Machine Code:</form:label></td>
			    	<td><form:input path="machineCode" value="${machineCode.machineCode }" required/></td>
			    </tr>
			    <tr>
			        <td><form:label path="description">Machine Description:</form:label></td>
			        <td><form:input path="description" value="${machineCode.description}" required/></td>
			    </tr>
			    <tr>
			        <td><form:label path="hourlyRate">Hourly Rate:</form:label></td>
			        <td><form:input path="hourlyRate" value="${machineCode.hourlyRate}" required/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="maxHours">Max hours per day:</form:label></td>
                    <td><form:input path="maxHours" value="${machineCode.maxHours}" required/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
</body>
</html>