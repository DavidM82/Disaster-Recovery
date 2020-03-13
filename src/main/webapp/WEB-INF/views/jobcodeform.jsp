<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Add/Edit Job Code</title>
</head>
<body>
<h2>Add A Job Code</h2>
		<form:form method="POST" action="jobCode.html">
	   		<table>
			    <tr>
			        <form:hidden path="jobCodeId" value="${jobCode.jobCodeId}"/>
			    </tr>
			    <tr>
			    	<td><form:label path="jobCode">Job Code:</form:label></td>
			    	<td><form:input path="jobCode" value="${jobCode.jobCode }" required="required"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="description">Job Description:</form:label></td>
			        <td><form:input path="description" value="${jobCode.description}" required="required"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="hourlyRate">Hourly Rate:</form:label></td>
			        <td><form:input path="hourlyRate" value="${jobCode.hourlyRate}" required="required"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="maxHours">Max hours per day:</form:label></td>
                    <td><form:input path="maxHours" value="${jobCode.maxHours}" required="required"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input class="button" type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
</body>
</html>