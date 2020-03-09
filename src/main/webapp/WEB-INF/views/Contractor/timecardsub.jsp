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
                  <p><a href="timecardstatus.html">Timecard Approval</a></p><br>
                   
                </div>
            
               <div class ="row2">
                <h3>Timesheet Submission</h3>
                <p> 
                Site Code:  <input type="text">
                Contractor Name:   <input type="text">
                Date:            <input type="date">

                

                </p>
                <form action="/timecard.html">
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

                         <td align ="right"><a href="addmore.html">Add More</a></td<br> 

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
            
                                     <td align ="right"><a href="addmore.html">Add More</a></td<br>   

                </table>  <br>
                                   <p><input type="submit" value="Submit"></p>
                                   <p><input type="reset" value="Reset"></p>
                           </form>
            </div>
            </body>
    
    
	
</html>