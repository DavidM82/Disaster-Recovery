<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
<title align ="right">Disaster Recovery Application: Timecard Submission</title>

</head>
 <div class="header" padding: 30px>
    <header>
        <h2>Disaster Recovery Application: Timecard Submission</h2>
        <h3>Admin</h3>
     </header>
    </div>
    
    <body>
            <div class = "row1">
               <section><a href="jobCodes.html">Job Code Management</a></section><br>
               <section><a href="machineCodes.html">Machine Code Management</a></section><br>
               <section><a href="timecardsAdmin.html">Time Card Approval</a></section><br>
               
            </div>
        
           <div class = "row2">
           <h2>Time Card Approval</h2>
           
            <table align="center" border="1">
                <tr>
                    <th>Site Code</th>
                    <th>Contractor Name</th>
                    <th>Total Hours </th>
                    <th>Total Amount</th>
                    <th>Status</th>
                    <th>Action</th>
                    
                </tr>

                <c:forEach items="${timeCards}" var="timeCard">
				<tr>
					<td><c:out value="${timeCard.siteCode}"/></td>
					<td><c:out value="${timeCard.contractorName}"/></td>
					<td><c:out value="${timeCard.totalHours} Hrs."/></td>
					<td><c:out value="$ ${timeCard.totalAmount}"/></td>
					<td><c:out value="${timeCard.approval}"/></td>
					<td><a href="timecardAdmin.html?timeCardId=${timeCard.timeCardId}">Edit</a></td>
				</tr>
				</c:forEach>
        
              
        </div>
        </body>



</html>