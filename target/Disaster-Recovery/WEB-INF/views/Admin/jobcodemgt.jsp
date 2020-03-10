<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link rel="stylesheet" href="styles.css" type="text/css">
<title align ="right">Disaaaster Recovery Application: Timecard Submission</title>

</head>
 <div class="header" padding: 30px>
    <header>
        <h2>Disaster Recovery Application: Timecard Submission</h2>
        <h3>Admin</h3>
     </header>
    </div>
    
<body>


        
        
            <div class = "row1">
               <section><a href="jobcodemgt.html">Job Code Management</a></section><br>
               <section><a href="machinemgt.html">Machine Managment</a></section><br>
               <section><a href="timecardapp.html">Timecard Approval</a></section><br>
               
            </div>
        
           <div class = "row2">
           <h2>Job Code Management</h2>
            <a href="addnew.html">Add New</a><br> 
            <table align="center" border="1">
                <tr>
                    <th>Job Code</th>
                    <th>Description</th>
                    <th>Hourly Rate</th>
                    <th>Max Hours Per Day</th>
                    
                </tr>
        
                    <tr>
                        <td>Plumber</td>
                        <td>Fix the Plumbing</td>
                        <td>$65/Hr </td>
                        <td>6 HR</td>
                        <td><a href="edit.html">Edit</a></td>
                        <td><a href="delete.html">Delete</a></td>
                    </tr>
                    
                    <tr>
                        <td>Carpenter</td>
                        <td>Wood work</td>
                        <td>$50/hr </td>
                        <td>4 HR</td>
                        <td><a href="edit.html">Edit</a></td>
                        <td><a href="delete.html">Delete</a></td>
                      
                        
                    </tr>
                    
                          
                    <tr>
                        <td>Electrician</td>
                        <td>Electric work</td>
                        <td>$45/hr </td>
                        <td>4 HR</td>
                        <td><a href="edit.html">Edit</a></td>
                        <td><a href="delete.html">Delete</a></td>
                                          
                    </tr>

                    <tr>
                        <td>General Labor</td>
                        <td>General work</td>
                        <td>$30/hr </td>
                        <td>8 HR</td>
                        <td><a href="edit.html">Edit</a></td>
                        <td><a href="delete.html">Delete</a></td>
                                          
                    </tr>
                    
                     
            </table>  <br>

              
        </div>
</body>
</html>