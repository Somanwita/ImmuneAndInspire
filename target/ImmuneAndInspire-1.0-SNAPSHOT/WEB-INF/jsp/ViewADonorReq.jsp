<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.neu.finalproject.pojo.VaccineProvider" %> 
<%@ page import="edu.neu.finalproject.pojo.AcceptedRequests" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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
       
        </style>
    </head>
    <body>
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>${sessionScope.requestersession.firstName } ${sessionScope.requestersession.lastName } - Vaccine Requester</p>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>
            <div><a href="${pageContext.request.contextPath}/viewreqprofile.htm">View Profile</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterprofile.htm">Update Profile</a></div>
            <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a></div> <br />
            <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a></div>

            <table border="1">
                <tr>
                    <td><b>Advertisement ID</b></td>
                    <td><b>Provider ID</b></td>
                    <td><b>Provider Name</b></td>
                    <td><b>Status</b></td>  
                    <td><b>Date Accepted</b></td>  
                    <td><b>Download Confirmation</b></td>
                </tr>
                <c:forEach var="ap" items="${applicants}">
                    <tr>
                        <td>${ap.requestAdvert.advertid}</td>
                        <td>${ap.provider.personID}</td>
                        <td>${ap.provider.firstName} ${ap.provider.lastName}</td>
                        <td>${ap.status}</td>                    
                        <td>${ap.dateaccepted}</td>   
                        <td>
                            <form role="form" action="${pageContext.request.contextPath}/downloadconfirmation/${ap.ARId}.pdf" method="post">
                                <button type="submit">Download Confirmation</button>
                            </form>
                        </td>                  
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>    
</html>