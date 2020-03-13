<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style><%@include file="/WEB-INF/style/generalstyle.css"%></style>
<title align ="right">Disaster Recovery Application: Machine Code Management</title>

</head>
 <div class="header" padding: 30px>
    <header>
        <h2>Disaster Recovery Application: Machine Code Management</h2>
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
           <h2>Machine Management</h2>
            <a href="addnewMachineCode.html">Add New</a><br> 
            <table align="center" border="1">
                <tr>
                    <th>Machine Code</th>
                    <th>Description</th>
                    <th>Hourly Rent</th>
                    <th>Max Hours Per Day</th>
                    <th>Actions</th>
                </tr>
        
       			<c:forEach items="${machineCodes}" var="machineCode">
				<tr>
					<td><c:out value="${machineCode.machineCode}"/></td>
					<td><c:out value="${machineCode.description}"/></td>
					<td><c:out value="$ ${machineCode.hourlyRate}/Hr."/></td>
					<td><c:out value="${machineCode.maxHours} Hr."/></td>
					<td><a href="editMachineCode.html?machineCodeId=${machineCode.machineCodeId}">Edit</a> |
					<a href="removeMachineCode.html?machineCodeId=${machineCode.machineCodeId}">Delete</a>
					</td>
				</tr>
				</c:forEach>    
            </table>  <br>

              
        </div>
        </body>



</html>