<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <link rel="stylesheet" href="styles.css" type="text/css">
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
                <h3>Time Card Submission</h3>
                
               <form:form method="POST" action="savetimecardCon.html">
	   			<table>
			    <tr>
			        <td><form:label path="timeCardId">Time Card Id: (Can't be changed)</form:label></td>
			        <td><form:input path="timeCardId" value="${timeCard.timeCardId}" readonly="true"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="siteCode">Site Code:</form:label></td>
			    	<td><form:input path="siteCode" value="${timeCard.siteCode }"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="contractorName">Contractor Name:</form:label></td>
			        <td><form:input path="contractorName" value="${timeCard.contractorName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="totalHours">Total Hours:</form:label></td>
			        <td><form:input path="totalHours" value="${timeCard.totalHours}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="totalAmount">Total Amount:</form:label></td>
                    <td><form:input path="totalAmount" value="${timeCard.totalAmount}"/></td>
			    </tr>
			    <form:hidden path="approval" value="pending"/>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
               
               
               
               
               
               <!--  <form action="/timecard.html">
                <table align="center" border="1">
                    <tr>
                        <th>Labor Entry</th>
                    </tr>
            
                        <tr>
                            <td>Labor code</td>
                               <td>
                                   <select id="laborcode">
                                <option value = "Plumbe">Plumber</option>
                                <option value = "Carpenter">Carpenter</option>
                                <option value = "Electrician">Electrician</option>
                                <option value = "General Labor">General Labor</option>
                               </select>
                               </td>
                              <td>
                                  Hours Worked
                                  <input type="number">
                              </td>
                              <td>
                               Total
                                <input type="number">
                            </td>
                         </tr>   
                        
                         <tr>
                            <td>Labor code</td>
                               <td>
                                   <select id="laborcode">
                                    <option value = "Plumbe">Plumber</option>
                                    <option value = "Carpenter">Carpenter</option>
                                    <option value = "Electrician">Electrician</option>
                                    <option value = "General Labor">General Labor</option>
                               </select>
                               </td>
                              <td>
                                  Hours Worked
                                  <input type="number">
                              </td>
                              <td>
                               Total
                                <input type="number">
                            </td>
                         </tr>   
                         <tr>
                            <td>Labor code</td>
                               <td>
                                   <select id="laborcode">
                                    <option value = "Plumbe">Plumber</option>
                                    <option value = "Carpenter">Carpenter</option>
                                    <option value = "Electrician">Electrician</option>
                                    <option value = "General Labor">General Labor</option>
                               </select>
                               </td>
                              <td>
                                  Hours Worked
                                  <input type="number">
                              </td>
                              <td>
                               Total
                                <input type="number">
                            </td>
                         </tr>   

                         <td align ="right"><a href="addmore.html">Add More</a></td><br> 

                         </table>   <br>
                            <table align="center" border="1">
                                <tr>
                                    <th>Machine Entry</th>
                                </tr>
                        
                                    <tr>
                                        <td>Machine code</td>
                                           <td>
                                               <select id="machinecode">
                                            <option value = "HT-100">HT-100</option>
                                            <option value = "AT-800">AT-800</option>
                                            <option value = "AirComp">AirComp</option>
                                            <option value = "Power Tools">Power Tools</option>
                                           </select>
                                           </td>
                                          <td>
                                              Hours used
                                              <input type="number">
                                          </td>
                                          <td>
                                           Total
                                            <input type="number">
                                        </td>
                                     </tr>   
                                    
                                     <tr>
                                        <td>Machine code</td>
                                           <td>
                                               <select id="machinecode">
                                                <option value = "HT-100">HT-100</option>
                                                <option value = "AT-800">AT-800</option>
                                                <option value = "AirComp">AirComp</option>
                                                <option value = "Power Tools">Power Tools</option>
                                           </select>
                                           </td>
                                          <td>
                                              Hours Used
                                              <input type="number">
                                          </td>
                                          <td>
                                           Total
                                            <input type="number">
                                        </td>
                                     </tr>   
                                     <tr>
                                        <td>Machine code</td>
                                           <td>
                                               <select id="machinecode">
                                                <option value = "HT-100">HT-100</option>
                                                <option value = "AT-800">AT-800</option>
                                                <option value = "AirComp">AirComp</option>
                                                <option value = "Power Tools">Power Tools</option>
                                           </select>
                                           </td>
                                          <td>
                                              Hours Used 
                                              <input type="number">
                                          </td>
                                          <td>
                                           Total
                                            <input type="number">
                                        </td>
                                     </tr>   
            
                                     <td align ="right"><a href="addmore.html">Add More</a></td> <br>   

                </table>  <br>
                                   <p><input type="submit" value="Submit"></p>
                                   <p><input type="reset" value="Reset"></p>
                           </form> -->
            </div>
            </body>
    
    
	
</html>