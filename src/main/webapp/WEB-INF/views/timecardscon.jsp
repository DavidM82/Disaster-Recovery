<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
		<title>Disaster Recovery </title>
	</head>
	
	  <div class="header">
        <header>
            <h2>Disaster Recovery Application: Timecard Submission</h2>
            <h3>Contractor</h3>
            
         </header>
        </div>
        <body>
               <div class ="row2">
             
            <h2>Time Card Status</h2>
             <a href="timecardCon.html">Add New Time Card</a><br> 
             <table align="center" border="1">
                 <tr>
                     <th>Site Code</th>
                     <th>Contractor Name</th>
                     <th>Total Hours</th>
                     <th>Total Amount</th>
                     <th>Time Card Status</th>
                     
                 </tr>
                <c:forEach items="${timeCards}" var="timeCard">
				<tr>
					<td><c:out value="${timeCard.siteCode}"/></td>
					<td><c:out value="${timeCard.contractorName}"/></td>
					<td><c:out value="${timeCard.totalHours} Hrs."/></td>
					<td><c:out value="$ ${timeCard.totalAmount}"/></td>
					<td><c:out value="${timeCard.approval}"/></td>
				</tr>
				</c:forEach>
                   
                        
                            
            </div>
            </body>
    
    
    
</html>