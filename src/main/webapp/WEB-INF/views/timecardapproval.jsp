<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
<title>Approve Time Card</title>
</head>
<body>
<h2>Modify Time Card Status</h2>
<form:form method="POST" action="savetimecardAdmin.html">
	   		<table>
			    <tr>
			        <form:hidden path="timeCardId" value="${timeCard.timeCardId}"/>
			    </tr>
			    <tr>
			    	<td><form:label path="contractorName">Contractor Name:</form:label></td>
			    	<td><form:input path="contractorName" value="${timeCard.contractorName }" readonly="true"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="siteCode">Site Code:</form:label></td>
			    	<td><form:input path="siteCode" value="${timeCard.siteCode}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="totalHours">Total Hours:</form:label></td>
			        <td><form:input path="totalHours" value="${timeCard.totalHours}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="totalAmount">Total Amount:</form:label></td>
			        <td><form:input path="totalAmount" value="${timeCard.totalAmount}" readonly="true"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="approval">Approval:</form:label></td>
                    <td><form:select path="approval">
                    	<form:option value="pending" label="Choose one"/>
                    		<form:option value="pending" label="pending" />
                    		<form:option value="approved" label="approved"/>
                    		<form:option value="declined" label="declined"/>
                    	</form:select>
                    </td>
			    </tr>
			    <tr>
			      <td colspan="2"><input class="button" type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
</body>
</html>