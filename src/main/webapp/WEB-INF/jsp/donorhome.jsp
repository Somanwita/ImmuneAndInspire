<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
        </style>
    </head>
    
    <body>
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Welcome Vaccine Provider : ${sessionScope.donorsession.firstName } ${sessionScope.donorsession.lastName }</p>
            <a href="#">Home</a> <br />
            <a href="${pageContext.request.contextPath}/donorprofile.htm">View/Update Profile</a>  <br /> 
            <a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a>  <br />     
            <a href="${pageContext.request.contextPath}/donorReq.htm">My Requests</a>  <br /> 
            <a href="${pageContext.request.contextPath}/addvaccine.htm">Add Vaccine</a> <br />
            <a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a> <br /> 
        </div>
    </body>
</html>