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
		
               <div class ="row1">
                <h2>Time Card Submission</h2>
                
               <form:form method="POST" action="savetimecardCon.html">
	   			<table>
			    <tr>
			    	<form:hidden path="timeCardId" value="${timeCard.timeCardId}"/>
			    </tr>
			    <tr>
			    	<td><form:label path="siteCode">Site Code:</form:label></td>
			    	<td><form:input path="siteCode" value="${timeCard.siteCode }" required="required"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="contractorName">Contractor Name:</form:label></td>
			        <td><form:input path="contractorName" value="${timeCard.contractorName}" required="required"/></td>
			    </tr>
				
				<tr>
					<td>
					<select id="jobCode1"	>
						<option value="0" label="Select Job Code"/>
						 <c:forEach items="${jobCodes}" var="jobCode">
						 <option value="${jobCode.hourlyRate }" label="${jobCode.jobCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours worked: <input id="jobHours1" value=0 onchange="multiplyHours(document.getElementById('jobHours1'), document.getElementById('jobCode1').value, document.getElementById('jobPrice1'))" type="number"/> </td>
					<td>Cost: <input id="jobPrice1" value=0 type="number" disabled></td>
				</tr>
				
				<tr>
					<td>
					<select id="jobCode2"	>
						<option value="0" label="Select Job Code"/>
						 <c:forEach items="${jobCodes}" var="jobCode">
						 <option value="${jobCode.hourlyRate }" label="${jobCode.jobCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours worked: <input id="jobHours2" value=0 onchange="multiplyHours(document.getElementById('jobHours2'), document.getElementById('jobCode2').value, document.getElementById('jobPrice2'))" type="number"/> </td>
					<td>Cost: <input id="jobPrice2" value=0 type="number" disabled></td>
				</tr>

				<tr>
					<td>
					<select id="jobCode3"	>
						<option value="0" label="Select Job Code"/>
						 <c:forEach items="${jobCodes}" var="jobCode">
						 <option value="${jobCode.hourlyRate }" label="${jobCode.jobCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours worked: <input id="jobHours3" value=0 onchange="multiplyHours(document.getElementById('jobHours3'), document.getElementById('jobCode3').value, document.getElementById('jobPrice3'))" type="number"/> </td>
					<td>Cost: <input id="jobPrice3" value=0 type="number" disabled></td>
				</tr>
				
				<tr>
					<td>
					<select id="machineCode1"	>
						<option value="0" label="Select Machine Code"/>
						 <c:forEach items="${machineCodes}" var="machineCode">
						 <option value="${machineCode.hourlyRate }" label="${machineCode.machineCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours Used: <input id="machineHours1" value=0 onchange="multiplyHours(document.getElementById('machineHours1'), document.getElementById('machineCode1').value, document.getElementById('machinePrice1'))" type="number"/> </td>
					<td>Cost: <input id="machinePrice1" value=0 type="number" disabled></td>
				</tr>
				
				<tr>
					<td>
					<select id="machineCode2"	>
						<option value="0" label="Select Machine Code"/>
						 <c:forEach items="${machineCodes}" var="machineCode">
						 <option value="${machineCode.hourlyRate }" label="${machineCode.machineCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours Used: <input id="machineHours2" value=0 onchange="multiplyHours(document.getElementById('machineHours2'), document.getElementById('machineCode2').value, document.getElementById('machinePrice2'))" type="number"/> </td>
					<td>Cost: <input id="machinePrice2" value=0 type="number" disabled></td>
				</tr>
				
				<tr>
					<td>
					<select id="machineCode3"	>
						<option value="0" label="Select Machine Code"/>
						 <c:forEach items="${machineCodes}" var="machineCode">
						 <option value="${machineCode.hourlyRate }" label="${machineCode.machineCode }"/>
						 </c:forEach>
					</select>
					</td>
					<td>Hours Used: <input id="machineHours3" value=0 onchange="multiplyHours(document.getElementById('machineHours3'), document.getElementById('machineCode3').value, document.getElementById('machinePrice3'))" type="number"/> </td>
					<td>Cost: <input id="machinePrice3" value=0 type="number" disabled></td>
				</tr>
				
			    <tr>
			        <td><form:label path="totalHours">Total Hours:</form:label></td>
			        <td><form:input id="totalHours" path="totalHours" value="${timeCard.totalHours}" default="0" readonly="true"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="totalAmount">Total Amount:</form:label></td>
                    <td><form:input id="totalAmount" path="totalAmount" value="${timeCard.totalAmount}" default="0" readonly="true"/></td>
			    </tr>
			    <form:hidden path="approval" value="pending"/>
			    <tr>
			      <td colspan="2"><input class="button" type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
          
    </div>
    <script>
    function multiplyHours(numhoursObject, jobHours, output ){
    	var numhours = parseInt(numhoursObject.value);
    	if (!numhours){
    		numhoursObject.value = 0;
    		numhours = 0;
    	}
    	
    	output.value = numhours * jobHours;
    	updateAmount();
    	updateHours();
    }
    
    function updateAmount(){
    	var amount = document.getElementById('totalAmount');
    	var job1 = parseInt(document.getElementById('jobPrice1').value);
    	var job2 = parseInt(document.getElementById('jobPrice2').value);
    	var job3 = parseInt(document.getElementById('jobPrice3').value);
    	var machine1 = parseInt(document.getElementById('machinePrice1').value);
    	var machine2 = parseInt(document.getElementById('machinePrice2').value);
    	var machine3 = parseInt(document.getElementById('machinePrice3').value);
    	amount.value = job1 + job2 + job3 + machine1 + machine2 + machine3;
    }
    
    function updateHours(){
    	var hours = document.getElementById("totalHours");
    	var job1 = parseInt(document.getElementById("jobHours1").value);
    	var job2 = parseInt(document.getElementById("jobHours2").value);
		var job3 = parseInt(document.getElementById('jobHours3').value);
		var machine1 = parseInt(document.getElementById('machineHours1').value);
		var machine2 = parseInt(document.getElementById('machineHours2').value);
		var machine3 = parseInt(document.getElementById('machineHours3').value);
    	hours.value = job1 + job2 + job3 + machine1 + machine2 + machine3;
    }
    
    </script>
</body>
    
    
	
</html>