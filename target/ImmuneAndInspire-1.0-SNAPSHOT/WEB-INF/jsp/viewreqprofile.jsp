<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
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
            legend {
                font-size: 2rem;
                font-weight: bold
            }
            p {
                color: #944e6c;
                font-size: 2rem;
            }
            label {
                display: inline-block;
                width: 180px;
                text-align: left;
                font-size: 1.4rem;
            }​
           
        </style>
    </head>
    <body>
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Vaccine Donor - ${sessionScope.requestersession.firstName } ${sessionScope.requestersession.lastName }</p>
            <div><a href="${pageContext.request.contextPath}/requesterhome.htm"><span>Home</span></a></div>
            <div><a href="${pageContext.request.contextPath}/requesterprofile.htm">Update Profile</a></div>
            <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a></div>
            <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>
            <br /> <br />

            <div>
                <form:form role="form" action="gobackreqhome.htm" commandName = "requester" method="post">
                    <fieldset>
                        <legend>View Your Profile :</legend>
                        <br />
                        <label><b>First Name:</b></label> 
                        <form:input path="firstName" value = "${sessionScope.requestersession.firstName }" disabled="true"/> <br /><br />
                        <label><b>Last Name</b></label> 
                        <form:input path="lastName" value = "${sessionScope.requestersession.lastName }" disabled="true"/> <br /><br />
                        <label><b>Password</b></label>
                        <form:input path= "password" value = "${sessionScope.requestersession.password }" disabled="true"/> <br /><br />
                        <label><b>Email</b></label>
                        <form:input path="email" value = "${sessionScope.requestersession.email }" disabled="true"/> <br /><br />
                        <label><b>Gender</b></label>
                        <form:input path= "gender" value = "${sessionScope.requestersession.gender }" disabled="true"/> <br /><br />
                        <label><b>Age</b></label> 
                        <form:input path="age" value = "${sessionScope.requestersession.age }" disabled="true"/> <br /><br />
                        <label><b>Address</b></label>
                        <form:input path= "requestedAddress" value = "${sessionScope.requestersession.requestedAddress }" disabled="true"/> <br /><br />
                        <label><b>City</b></label> 
                        <form:input path="requestedCity" value = "${sessionScope.requestersession.requestedCity }" disabled="true"/> <br /><br />
                        <label><b>Phone Number</b></label> 
                        <form:input path= "phoneNumber" value = "${sessionScope.requestersession.phoneNumber }" disabled="true"/> <br /><br />
                        <label><b>Vaccine Name</h4></b></label> 
                        <form:input path= "requestedvaccines" value = "${sessionScope.requestersession.requestedvaccines }" disabled="true"/> <br /><br />
                        <div><input type="submit" value="Click Ok" tabindex="7"></div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </body>
</html>