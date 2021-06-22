<%-- 
    Document   : login
    Created on : Nov 25, 2020, 9:54:52 PM
    Author     : soman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
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
        <h1><em>Immune And Inspire</em></h1>
        <p>Enter your username and password to log on:</p>
        
        <form:form role="form" action = "loginpage.htm" commandName = "person" method="post">
        
            <div>
                <label>Username</label>
                <form:input path="firstName" placeholder="Username"/>
                <form:errors path="firstName"/>
            </div> <br />
            <div>
                <label>Password</label>
                <form:password path="password" placeholder="Password"/>
                <form:errors path="password"/>
            </div>  <br />
            <button>Log in</button> <br />   
            <div>
                <c:if test="${!empty requestScope.error}">
                    <p style="color:red">UserName/Password Incorrect</p>
                </c:if>
            </div>
        </form:form>
    
        <b>New User? Sign in here!</b><br />
        <a href="donorregistration.htm"><b>Donor Registration</b></a> <br />
        <a href="requesterregistration.htm"><b>Requester Registration</b></a>
    </body>
</html>
