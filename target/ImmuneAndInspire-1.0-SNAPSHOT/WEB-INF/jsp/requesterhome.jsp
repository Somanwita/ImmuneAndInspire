<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <p>Vaccine Requester Full Name - ${sessionScope.requestersession.firstName } ${sessionScope.requestersession.lastName }</p> 
            <div><a href="#">Home</a> </div>
            <div><a href="${pageContext.request.contextPath}/viewreqprofile.htm">View Profile</a> <div />
            <div><a href="${pageContext.request.contextPath}/requesterprofile.htm">Update Profile</a> <div />
            <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a> <div />
            <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a> <div/>  
            <div><a href="requesterlogout.htm">Sign out</a> </div>
        </div>
    </body>
</html>