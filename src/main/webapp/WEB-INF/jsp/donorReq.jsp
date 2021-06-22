<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html lang="en">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    <%@ page session = "true" %>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
       
    </head>
    <body>
        
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Vaccine Provider - ${sessionScope.donorsession.firstName} ${sessionScope.donorsession.lastName }</p></div>
            <div><a href="${pageContext.request.contextPath}/donorhome.htm">Home</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>
            <div><a href="${pageContext.request.contextPath}/donorprofile.htm">View/Update Profile</a></div>
            <div><a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a></div> <br />
            <div><a href="#">My Requests</a>
        </div>
         
        <div>
            <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <td><b>Person ID</b></td>
                    <td><b>Accepted Request Id</b></td>
                    <td><b>Date Accepted</b></td>
                    <td><b>Request Status</b></td>   
                    <td><b>Requested Message</b></td> 
                    <td><b>Action</b></td>  
                </tr>
                <c:forEach var="dr" items="${emerRequ}">
                    <tr>
                        <td>${dr.provider.personID}</td>
                        <td>${dr.ARId}</td> 
                        <td>${dr.dateaccepted}</td>
                        <td>${dr.status}</td> 
                        <td>${dr.requestAdvert.message}</td> 
                        <td><a href="${pageContext.request.contextPath}/updatestatus/${dr.ARId}.htm"><button type="button">Update Status</button></a></td>
                    </tr>
                </c:forEach> 
            </table>
        </div>

   `  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
      <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    </body>    
</html>