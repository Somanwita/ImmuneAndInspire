<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.neu.finalproject.pojo.VaccineProvider" %> 
<%@ page import="edu.neu.finalproject.pojo.AcceptedRequests" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <style>
            body {
                background-color: #c9cbff;
                font-family: "Times New Roman", Times, serif;
            }
            h1   {
                color: #944e6c;
                text-align: center;   
            }
            a {
                font-size: 2rem;
            }
            p {
                color: #944e6c;
                font-size: 2rem;
            }
            
            button:hover {
                color: white;
                background-color: black;
            }
        </style>
        <script>
            function accept(el) {
                var id = $(el).closest("tr").find('td:eq(0) input').val();
                var id1 = $(el).closest("tr").find('td:eq(5) input').val();
                alert(id);
                alert(id1);
                $.ajax({
                    type: "GET",
                    url:  "updateSta/"+id+"/"+id1+".htm",
                    data: "id=" + id + "id1=" + id1,
                    success: function (response) {
                        $(el).closest("tr").remove();
                        alert("Request Number " + id + " updated successfully");
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });
            }
        </script>
    </head>
    
    <body>
        <div>
            <div>
                <h1><em>Immune And Inspire</em></h1>
                <div><p>Vaccine Provider - ${sessionScope.donorsession.firstName} ${sessionScope.donorsession.lastName }</p></div>
                <div><a href="${pageContext.request.contextPath}/donorhome.htm">Home</a></div>
                <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>
                <div><a href="${pageContext.request.contextPath}/donorprofile.htm">View/Update Profile</a></div>
                <div><a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a></div> 
            </div>
         
            <h2>Change Request Status</h2>
            <form role="updateform" action="${pageContext.request.contextPath}/updateSta/${updateSt.ARId}.htm"> 

            <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <td><b>Person ID</b></td>
                    <td><b>Accepted Request Id</b></td>
                    <td><b>Status</b></td>
                    <td><b>Action</b></td>
                </tr>
                <tr>
                    <td>${updateSt.provider.personID}</td>
                    <td>${updateSt.ARId}</td>
                    <td>${updateSt.status}</td>
                    <td> 
                    <select name="Status" class="form-control">
			<option value="Request Accepted">Request Accepted</option>
			<option value="Request Completed">Request Completed</option>
                        <option value="Request Cancelled">Request Cancelled</option>
                    </select></td> 	
                </tr>    
            </table>       
            <button type="submit" >Update Status</button>    
        </form>
      
      </div>
  
</body>    
</html>